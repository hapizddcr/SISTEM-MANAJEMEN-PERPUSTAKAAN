/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;
import config.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import session.Session;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

import javax.swing.JFileChooser;
/**
 *
 * @author hapiz
 */
public class PanelPengembalian extends javax.swing.JPanel {
    
    /**
     * Creates new form PanelPengembalian
     */
    private int terlambat = 0;

    private int denda = 0;
    public PanelPengembalian() {
        initComponents();
        loadTable();
        loadRiwayatPengembalian();

        txtUser.setEditable(false);

        txtBuku.setEditable(false);

        txtTanggal.setEditable(false);

        txtTerlambat.setEditable(false);

        txtDenda.setEditable(false);

        btnProses.setEnabled(false);

        btnCetak.setEnabled(false);
        
        tablePengembalian.setDefaultEditor(
        Object.class,
        null
        );
        tableRiwayatPengembalian.setDefaultEditor(
        Object.class,
        null
        );
    }
     // =====================================
    // LOAD TABLE
    // =====================================
    private void loadRiwayatPengembalian() {

    DefaultTableModel model =
            new DefaultTableModel();

    model.addColumn("ID");
    model.addColumn("User");
    model.addColumn("Buku");
    model.addColumn("Tgl Pinjam");
    model.addColumn("Tgl Kembali");
    model.addColumn("Status");
    model.addColumn("Diproses Oleh");

    try {

        Connection c =
                Koneksi.getConnection();

        String sql =
                "SELECT p.id, "
                + "u.nama_lengkap, "
                + "b.judul, "
                + "p.tanggal_pinjam, "
                + "p.tanggal_kembali, "
                + "p.status, "
                + "p.diproses_oleh "
                + "FROM peminjaman p "
                + "JOIN users u ON p.user_id=u.id "
                + "JOIN detail_peminjaman d ON p.id=d.peminjaman_id "
                + "JOIN buku b ON d.buku_id=b.id "
                + "WHERE p.status='dikembalikan' "
                + "ORDER BY p.id DESC";

        PreparedStatement p =
                c.prepareStatement(sql);

        ResultSet r =
                p.executeQuery();

        while(r.next()) {

            model.addRow(new Object[] {

                r.getString("id"),
                r.getString("nama_lengkap"),
                r.getString("judul"),
                r.getString("tanggal_pinjam"),
                r.getString("tanggal_kembali"),
                r.getString("status"),
                r.getString("diproses_oleh")
            });
        }

        tableRiwayatPengembalian.setModel(
                model
        );

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );
    }
}
    private void loadTable() {

        DefaultTableModel model =
                new DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {

                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("User");
        model.addColumn("Buku");
        model.addColumn("Tanggal Pinjam");
        model.addColumn("Tanggal Kembali");
        model.addColumn("Status");

        try {

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT p.id, "
                    + "u.nama_lengkap, "
                    + "b.id AS buku_id, "
                    + "b.judul, "
                    + "p.tanggal_pinjam, "
                    + "p.tanggal_kembali, "
                    + "p.status "
                    + "FROM peminjaman p "
                    + "JOIN users u "
                    + "ON p.user_id=u.id "
                    + "JOIN detail_peminjaman d "
                    + "ON p.id=d.peminjaman_id "
                    + "JOIN buku b "
                    + "ON d.buku_id=b.id "
                    + "WHERE p.status='dipinjam'";

            PreparedStatement p =
                    c.prepareStatement(sql);

            ResultSet r =
                    p.executeQuery();

            while(r.next()) {

                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("nama_lengkap"),

                    r.getString("judul"),

                    r.getString("tanggal_pinjam"),

                    r.getString("tanggal_kembali"),

                    r.getString("status")
                });
            }

            tablePengembalian.setModel(model);

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }

    // =====================================
    // CARI DATA
    // =====================================

    private void cariData() {

        DefaultTableModel model =
                new DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {

                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("User");
        model.addColumn("Buku");
        model.addColumn("Tanggal Pinjam");
        model.addColumn("Tanggal Kembali");
        model.addColumn("Status");

        try {

            String keyword =
                    txtCari.getText();

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT p.id, "
                    + "u.nama_lengkap, "
                    + "b.judul, "
                    + "p.tanggal_pinjam, "
                    + "p.tanggal_kembali, "
                    + "p.status "
                    + "FROM peminjaman p "
                    + "JOIN users u "
                    + "ON p.user_id=u.id "
                    + "JOIN detail_peminjaman d "
                    + "ON p.id=d.peminjaman_id "
                    + "JOIN buku b "
                    + "ON d.buku_id=b.id "
                    + "WHERE p.status='dipinjam' "
                    + "AND ("
                    + "u.nama_lengkap LIKE ? "
                    + "OR b.judul LIKE ?"
                    + ")";

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(
                    1,
                    "%" + keyword + "%"
            );

            p.setString(
                    2,
                    "%" + keyword + "%"
            );

            ResultSet r =
                    p.executeQuery();

            while(r.next()) {

                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("nama_lengkap"),

                    r.getString("judul"),

                    r.getString("tanggal_pinjam"),

                    r.getString("tanggal_kembali"),

                    r.getString("status")
                });
            }

            tablePengembalian.setModel(model);

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtBuku = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtTerlambat = new javax.swing.JTextField();
        txtDenda = new javax.swing.JTextField();
        lblBuku = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        lblTerlambat = new javax.swing.JLabel();
        lblDenda = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePengembalian = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRiwayatPengembalian = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        lblCari.setText("Cari Data:");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        lblUser.setText("User: ");

        txtTerlambat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTerlambatActionPerformed(evt);
            }
        });

        lblBuku.setText("Buku: ");

        lblTanggal.setText("Tanggal: ");

        lblTerlambat.setText("Terlambat: ");

        lblDenda.setText("Denda: ");

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        tablePengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePengembalianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePengembalian);

        tableRiwayatPengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRiwayatPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRiwayatPengembalianMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableRiwayatPengembalian);

        jLabel1.setText("Riwayat Pengembalian: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCari)
                            .addComponent(lblUser)
                            .addComponent(lblBuku)
                            .addComponent(lblTanggal)
                            .addComponent(lblTerlambat)
                            .addComponent(lblDenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnProses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCetak)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCari)
                            .addComponent(txtUser)
                            .addComponent(txtBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(txtTerlambat, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(txtDenda, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTerlambat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTerlambat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProses)
                    .addComponent(btnCetak))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTerlambatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTerlambatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTerlambatActionPerformed

    private void tablePengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePengembalianMouseClicked
        // TODO add your handling code here:
        int baris =
                tablePengembalian.getSelectedRow();

        txtUser.setText(
                tablePengembalian.getValueAt(baris, 1)
                .toString()
        );

        txtBuku.setText(
                tablePengembalian.getValueAt(baris, 2)
                .toString()
        );

        txtTanggal.setText(
                tablePengembalian.getValueAt(baris, 4)
                .toString()
        );

        // HITUNG TERLAMBAT

        try {

            LocalDate tanggalKembali =
                    LocalDate.parse(
                            tablePengembalian
                            .getValueAt(baris, 4)
                            .toString()
                    );

            LocalDate hariIni =
                    LocalDate.now();

            long selisih =
                    ChronoUnit.DAYS.between(
                            tanggalKembali,
                            hariIni
                    );

            if(selisih > 0) {

                terlambat =
                        (int) selisih;

                denda =
                        terlambat * 1000;

            } else {

                terlambat = 0;

                denda = 0;
            }

            txtTerlambat.setText(
                    terlambat + " Hari"
            );

            txtDenda.setText(
                    "Rp " + denda
            );

        } catch(Exception e) {

            txtTerlambat.setText("0");

            txtDenda.setText("0");
        }

        btnProses.setEnabled(true);

        btnCetak.setEnabled(true);
    }//GEN-LAST:event_tablePengembalianMouseClicked

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        try {

            int pilih =
                    JOptionPane.showConfirmDialog(
                            null,
                            "Proses pengembalian buku?",
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION
                    );

            if(pilih != JOptionPane.YES_OPTION) {

                return;
            }

            int baris =
                    tablePengembalian.getSelectedRow();

            String idPeminjaman =
                    tablePengembalian
                    .getValueAt(baris, 0)
                    .toString();

            String judul =
                    tablePengembalian
                    .getValueAt(baris, 2)
                    .toString();

            Connection c =
                    Koneksi.getConnection();

            // UPDATE STATUS

            String sql =
                    "UPDATE peminjaman "
                    + "SET "
                    + "status='dikembalikan', "
                    + "diproses_oleh=? "
                    + "WHERE id=?";

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(
                    1,
                Session.namaLengkap
            );

            p.setString(
                    2,
                idPeminjaman
            );

            p.executeUpdate();

            // UPDATE STOK

            String sqlStok =
                    "UPDATE buku "
                    + "SET stok=stok+1 "
                    + "WHERE judul=?";

            PreparedStatement pStok =
                    c.prepareStatement(sqlStok);

            pStok.setString(
                    1,
                    judul
            );

            pStok.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Pengembalian berhasil"
            );

            loadTable();
            loadRiwayatPengembalian();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try {

        int baris =
                tableRiwayatPengembalian.getSelectedRow();

        if(baris == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih data terlebih dahulu"
            );

            return;
        }

        // =====================================
        // AMBIL DATA
        // =====================================

        String id =
                tableRiwayatPengembalian
                .getValueAt(baris, 0)
                .toString();

        String nama =
                tableRiwayatPengembalian
                .getValueAt(baris, 1)
                .toString();

        String buku =
                tableRiwayatPengembalian
                .getValueAt(baris, 2)
                .toString();

        String tanggalPinjam =
                tableRiwayatPengembalian
                .getValueAt(baris, 3)
                .toString();

        String tanggalKembali =
                tableRiwayatPengembalian
                .getValueAt(baris, 4)
                .toString();

        String status =
                tableRiwayatPengembalian
                .getValueAt(baris, 5)
                .toString();

        // =====================================
        // FILE CHOOSER
        // =====================================

        JFileChooser chooser =
                new JFileChooser();

        chooser.setDialogTitle(
                "Simpan PDF"
        );

        int hasil =
                chooser.showSaveDialog(null);

        if(hasil != JFileChooser.APPROVE_OPTION) {

            return;
        }

        String path =
                chooser.getSelectedFile()
                .getAbsolutePath()
                + ".pdf";

        // =====================================
        // BUAT PDF
        // =====================================

        Document document =
                new Document();

        PdfWriter.getInstance(
                document,
                new FileOutputStream(path)
        );

        document.open();

        // =====================================
        // JUDUL
        // =====================================

        Font title =
                FontFactory.getFont(
                        FontFactory.HELVETICA_BOLD,
                        18
                );

        Paragraph judul =
                new Paragraph(
                        "BUKTI PENGEMBALIAN BUKU",
                        title
                );

        judul.setAlignment(
                Element.ALIGN_CENTER
        );

        document.add(judul);

        document.add(
                new Paragraph(" ")
        );

        // =====================================
        // ISI PDF
        // =====================================

        document.add(
                new Paragraph(
                        "ID Peminjaman : " + id
                )
        );

        document.add(
                new Paragraph(
                        "Nama User : " + nama
                )
        );

        document.add(
                new Paragraph(
                        "Judul Buku : " + buku
                )
        );

        document.add(
                new Paragraph(
                        "Tanggal Pinjam : "
                        + tanggalPinjam
                )
        );

        document.add(
                new Paragraph(
                        "Tanggal Kembali : "
                        + tanggalKembali
                )
        );

        document.add(
                new Paragraph(
                        "Status : " + status
                )
        );

        document.add(
                new Paragraph(
                        "Diproses Oleh : "
                        + Session.namaLengkap
                )
        );

        document.add(
                new Paragraph(" ")
        );

        document.add(
                new Paragraph(
                        "Buku telah " + status
                )
        );

        // =====================================
        // CLOSE PDF
        // =====================================

        document.close();

        JOptionPane.showMessageDialog(
                null,
                "PDF berhasil disimpan"
        );

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );
    }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased

    private void tableRiwayatPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRiwayatPengembalianMouseClicked
        // TODO add your handling code here:
         int baris =
                tableRiwayatPengembalian.getSelectedRow();

        txtUser.setText(
                tableRiwayatPengembalian.getValueAt(baris, 1)
                .toString()
        );

        txtBuku.setText(
                tableRiwayatPengembalian.getValueAt(baris, 2)
                .toString()
        );

        txtTanggal.setText(
                tableRiwayatPengembalian.getValueAt(baris, 4)
                .toString()
        );

        // HITUNG TERLAMBAT

        try {

            LocalDate tanggalKembali =
                    LocalDate.parse(
                            tableRiwayatPengembalian
                            .getValueAt(baris, 4)
                            .toString()
                    );

            LocalDate hariIni =
                    LocalDate.now();

            long selisih =
                    ChronoUnit.DAYS.between(
                            tanggalKembali,
                            hariIni
                    );

            if(selisih > 0) {

                terlambat =
                        (int) selisih;

                denda =
                        terlambat * 1000;

            } else {

                terlambat = 0;

                denda = 0;
            }

            txtTerlambat.setText(
                    terlambat + " Hari"
            );

            txtDenda.setText(
                    "Rp " + denda
            );

        } catch(Exception e) {

            txtTerlambat.setText("0");

            txtDenda.setText("0");
        }

        btnProses.setEnabled(true);

        btnCetak.setEnabled(true);
    }//GEN-LAST:event_tableRiwayatPengembalianMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnProses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuku;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblDenda;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTerlambat;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tablePengembalian;
    private javax.swing.JTable tableRiwayatPengembalian;
    private javax.swing.JTextField txtBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDenda;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTerlambat;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;
import config.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
public class PanelPeminjamanAdmin extends javax.swing.JPanel {

    /**
     * Creates new form PanelPeminjamanAdmin
     */
    public PanelPeminjamanAdmin() {
        initComponents();
        loadTable();

        txtUser.setEditable(false);

        txtBuku.setEditable(false);

        txtStatus.setEditable(false);

        txtTanggal.setEditable(false);
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

            tablePeminjaman.setModel(model);

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
                    + "OR b.judul LIKE ? "
                    + "OR p.status LIKE ?"
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

            p.setString(
                    3,
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

            tablePeminjaman.setModel(model);

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
        txtStatus = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        lblBuku = new javax.swing.JLabel();
        lblBuku1 = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePeminjaman = new javax.swing.JTable();

        lblCari.setText("Cari Peminjaman: ");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        lblUser.setText("User: ");

        txtBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBukuActionPerformed(evt);
            }
        });

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });

        lblBuku.setText("Buku: ");

        lblBuku1.setText("Status: ");

        lblTanggal.setText("Tanggal: ");

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        tablePeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePeminjaman);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCari)
                            .addComponent(lblUser)
                            .addComponent(lblBuku)
                            .addComponent(lblBuku1)
                            .addComponent(lblTanggal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCetak)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCari)
                            .addComponent(txtUser)
                            .addComponent(txtBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuku)
                    .addComponent(txtBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuku1)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTanggal)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBukuActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void tablePeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePeminjamanMouseClicked
        // TODO add your handling code here:
        int baris =
                tablePeminjaman.getSelectedRow();

        txtUser.setText(
                tablePeminjaman.getValueAt(baris, 1)
                .toString()
        );

        txtBuku.setText(
                tablePeminjaman.getValueAt(baris, 2)
                .toString()
        );

        txtTanggal.setText(
                tablePeminjaman.getValueAt(baris, 3)
                .toString()
        );

        txtStatus.setText(
                tablePeminjaman.getValueAt(baris, 5)
                .toString()
        );
    }//GEN-LAST:event_tablePeminjamanMouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
         try {

        int baris =
                tablePeminjaman.getSelectedRow();

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
                tablePeminjaman
                .getValueAt(baris, 0)
                .toString();

        String nama =
                tablePeminjaman
                .getValueAt(baris, 1)
                .toString();

        String buku =
                tablePeminjaman
                .getValueAt(baris, 2)
                .toString();

        String tanggalPinjam =
                tablePeminjaman
                .getValueAt(baris, 3)
                .toString();

        String tanggalKembali =
                tablePeminjaman
                .getValueAt(baris, 4)
                .toString();

        String status =
                tablePeminjaman
                .getValueAt(baris, 5)
                .toString();

        // =====================================
        // PILIH LOKASI SAVE
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
        // ISI PDF
        // =====================================

        Font title =
                FontFactory.getFont(
                        FontFactory.HELVETICA_BOLD,
                        18
                );

        Paragraph judul =
                new Paragraph(
                        "BUKTI PEMINJAMAN BUKU",
                        title
                );

        judul.setAlignment(
                Element.ALIGN_CENTER
        );

        document.add(judul);

        document.add(
                new Paragraph(" ")
        );

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
                new Paragraph(" ")
        );

        document.add(
                new Paragraph(
                        "Buku sedang " + status
                )
        );

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuku;
    private javax.swing.JLabel lblBuku1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tablePeminjaman;
    private javax.swing.JTextField txtBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package user;
import config.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import session.Session;
/**
 *
 * @author hapiz
 */
public class PanelFavorit extends javax.swing.JPanel {

    /**
     * Creates new form PanelFavorit
     */
    public PanelFavorit() {
        initComponents();
        loadTable();

        txtJudul.setEditable(false);

        txtPengarang.setEditable(false);

        txtPenerbit.setEditable(false);

        txtStok.setEditable(false);

        setBackground(java.awt.Color.WHITE);

        java.awt.Font boldLabel = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12);
        for (javax.swing.JLabel lb : new javax.swing.JLabel[]{
            lblCari, lblJudul, lblPengarang, lblPenerbit
        }) {
            lb.setFont(boldLabel);
        }

        btnHapus.setBackground(new java.awt.Color(231, 76, 60));
        btnHapus.setForeground(java.awt.Color.WHITE);
        btnHapus.setFocusPainted(false);
        btnHapus.setBorderPainted(false);
        btnHapus.setToolTipText("Hapus dari daftar favorit");

        txtCari.setToolTipText("Cari berdasarkan judul, pengarang, atau penerbit");
    }
    // =====================================
    // LOAD TABLE
    // =====================================

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
        model.addColumn("Judul");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Tahun");
        model.addColumn("Stok");
        model.addColumn("Status");

        try {

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT f.id, "
                    + "b.judul, "
                    + "b.pengarang, "
                    + "b.penerbit, "
                    + "b.tahun, "
                    + "b.stok "
                    + "FROM favorit f "
                    + "JOIN buku b "
                    + "ON f.buku_id=b.id "
                    + "WHERE f.user_id=?";

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setInt(
                    1,
                    Session.idUser
            );

            ResultSet r =
                    p.executeQuery();

            while(r.next()) {
                 String status;

                if (r.getInt("stok") > 0) {
                    status = "Tersedia";
                } else {
                    status = "Habis";
                }
                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("judul"),

                    r.getString("pengarang"),

                    r.getString("penerbit"),

                    r.getString("tahun"),

                    r.getString("stok"),
                    status
                });
            }

            tableFavorit.setModel(model);

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
        model.addColumn("Judul");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Tahun");
        model.addColumn("Stok");
        model.addColumn("Status");

        try {

            String keyword =
                    txtCari.getText();

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT f.id, "
                    + "b.id AS buku_id, "
                    + "b.judul, "
                    + "b.pengarang, "
                    + "b.penerbit, "
                    + "b.tahun, "
                    + "b.stok "
                    + "FROM favorit f "
                    + "JOIN buku b "
                    + "ON f.buku_id=b.id "
                    + "WHERE f.user_id=? "
                    + "AND ("
                    + "b.judul LIKE ? "
                    + "OR b.pengarang LIKE ? "
                    + "OR b.penerbit LIKE ?"
                    + ")";

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setInt(
                    1,
                    Session.idUser
            );

            p.setString(
                    2,
                    "%" + keyword + "%"
            );

            p.setString(
                    3,
                    "%" + keyword + "%"
            );

            p.setString(
                    4,
                    "%" + keyword + "%"
            );

            ResultSet r =
                    p.executeQuery();

            while(r.next()) {
                String status;

                if (r.getInt("stok") > 0) {
                    status = "Tersedia";
                } else {
                    status = "Habis";
                }
                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("judul"),

                    r.getString("pengarang"),

                    r.getString("penerbit"),

                    r.getString("tahun"),

                    r.getString("stok"),
                    status
                });
            }

            tableFavorit.setModel(model);

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
        lblJudul = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        txtPengarang = new javax.swing.JTextField();
        txtPenerbit = new javax.swing.JTextField();
        lblPengarang = new javax.swing.JLabel();
        lblPenerbit = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFavorit = new javax.swing.JTable();
        txtStok = new javax.swing.JTextField();
        lblPenerbit1 = new javax.swing.JLabel();
        btnPinjam = new javax.swing.JButton();

        lblCari.setText("Cari Favorit: ");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        lblJudul.setText("Judul: ");

        txtPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenerbitActionPerformed(evt);
            }
        });

        lblPengarang.setText("Pengarang: ");

        lblPenerbit.setText("Penerbit: ");

        btnHapus.setText("Hapus Favorit");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tableFavorit.setModel(new javax.swing.table.DefaultTableModel(
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
        tableFavorit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFavoritMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableFavorit);

        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });

        lblPenerbit1.setText("Stok:");

        btnPinjam.setText("Pinjam");
        btnPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinjamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCari)
                            .addComponent(lblJudul)
                            .addComponent(lblPengarang)
                            .addComponent(lblPenerbit)
                            .addComponent(lblPenerbit1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCari)
                            .addComponent(txtJudul)
                            .addComponent(txtPengarang, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(txtPenerbit)
                            .addComponent(txtStok)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPinjam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
                    .addComponent(lblJudul)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPengarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPenerbit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPenerbit1)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPinjam)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenerbitActionPerformed

    private void tableFavoritMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFavoritMouseClicked
        // TODO add your handling code here:
        int baris =
                tableFavorit.getSelectedRow();

        txtJudul.setText(
                tableFavorit.getValueAt(baris, 1)
                .toString()
        );

        txtPengarang.setText(
                tableFavorit.getValueAt(baris, 2)
                .toString()
        );

        txtPenerbit.setText(
                tableFavorit.getValueAt(baris, 3)
                .toString()
        );

        txtStok.setText(
                tableFavorit.getValueAt(baris, 5)
                .toString()
        );
    }//GEN-LAST:event_tableFavoritMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {

            int baris =
                    tableFavorit.getSelectedRow();

            if(baris == -1) {

                JOptionPane.showMessageDialog(
                        null,
                        "Pilih data terlebih dahulu"
                );

                return;
            }

            int pilih =
                    JOptionPane.showConfirmDialog(
                            null,
                            "Hapus dari favorit?",
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION
                    );

            if(pilih != JOptionPane.YES_OPTION) {

                return;
            }

            String id =
                    tableFavorit.getValueAt(baris, 0)
                    .toString();

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "DELETE FROM favorit "
                    + "WHERE id=?";

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(1, id);

            p.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Favorit berhasil dihapus"
            );

            loadTable();

            txtJudul.setText("");

            txtPengarang.setText("");

            txtPenerbit.setText("");

            txtStok.setText("");

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void btnPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinjamActionPerformed
        // TODO add your handling code here:
         try {

        int baris = tableFavorit.getSelectedRow();

        if (baris == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih buku terlebih dahulu!"
            );

            return;
        }

        int stok = Integer.parseInt(
                tableFavorit.getValueAt(baris, 5).toString()
        );

        if (stok <= 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Maaf, stok buku habis."
            );

            return;
        }

        String idFavorit =
                tableFavorit.getValueAt(baris, 0).toString();

        Connection c =
                Koneksi.getConnection();

        // ===============================
        // Ambil buku_id dari tabel favorit
        // ===============================

        String sqlFavorit =
                "SELECT buku_id "
                + "FROM favorit "
                + "WHERE id=?";

        PreparedStatement pFavorit =
                c.prepareStatement(sqlFavorit);

        pFavorit.setString(1, idFavorit);

        ResultSet r =
                pFavorit.executeQuery();

        if (!r.next()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Data favorit tidak ditemukan."
            );

            return;
        }

        int bukuId = r.getInt("buku_id");

        // ===============================
        // Simpan ke tabel peminjaman
        // ===============================

        String sqlPinjam =
                "INSERT INTO peminjaman"
                + "(user_id,tanggal_pinjam,tanggal_kembali,status)"
                + "VALUES(?,NOW(),DATE_ADD(NOW(),INTERVAL 7 DAY),'dipinjam')";

        PreparedStatement pPinjam =
                c.prepareStatement(
                        sqlPinjam,
                        PreparedStatement.RETURN_GENERATED_KEYS
                );

        pPinjam.setInt(
                1,
                Session.idUser
        );

        pPinjam.executeUpdate();

        ResultSet rsId =
                pPinjam.getGeneratedKeys();

        rsId.next();

        int idPeminjaman =
                rsId.getInt(1);

        // ===============================
        // Simpan detail peminjaman
        // ===============================

        String sqlDetail =
                "INSERT INTO detail_peminjaman"
                + "(peminjaman_id,buku_id)"
                + "VALUES(?,?)";

        PreparedStatement pDetail =
                c.prepareStatement(sqlDetail);

        pDetail.setInt(1, idPeminjaman);
        pDetail.setInt(2, bukuId);

        pDetail.executeUpdate();

        // ===============================
        // Kurangi stok buku
        // ===============================

        String sqlStok =
                "UPDATE buku "
                + "SET stok=stok-1 "
                + "WHERE id=?";

        PreparedStatement pStok =
                c.prepareStatement(sqlStok);

        pStok.setInt(1, bukuId);

        pStok.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "Buku berhasil dipinjam."
        );

        loadTable();
        txtJudul.setText("");

        txtPengarang.setText("");

        txtPenerbit.setText("");

        txtStok.setText("");
    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );
    }
    }//GEN-LAST:event_btnPinjamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPinjam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblPenerbit;
    private javax.swing.JLabel lblPenerbit1;
    private javax.swing.JLabel lblPengarang;
    private javax.swing.JTable tableFavorit;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}

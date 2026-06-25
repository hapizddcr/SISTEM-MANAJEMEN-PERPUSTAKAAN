/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;
import config.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hapiz
 */
public class PanelBukuAdmin extends javax.swing.JPanel {

    /**
     * Creates new form PanelBukuAdmin
     */
    public PanelBukuAdmin() {
        initComponents();
        loadTable();

        btnEdit.setEnabled(false);

        btnHapus.setEnabled(false);

        setBackground(java.awt.Color.WHITE);

        java.awt.Font boldLabel = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12);
        for (javax.swing.JLabel lb : new javax.swing.JLabel[]{
            lblCari, lblJudul, lblPengarang, lblPenerbit, lblTahun, lblStok
        }) {
            lb.setFont(boldLabel);
        }

        btnTambah.setBackground(new java.awt.Color(52, 152, 219));
        btnTambah.setForeground(java.awt.Color.WHITE);
        btnTambah.setFocusPainted(false);
        btnTambah.setBorderPainted(false);
        btnTambah.setToolTipText("Tambah data buku baru");

        btnEdit.setBackground(new java.awt.Color(243, 156, 18));
        btnEdit.setForeground(java.awt.Color.WHITE);
        btnEdit.setFocusPainted(false);
        btnEdit.setBorderPainted(false);
        btnEdit.setToolTipText("Edit data buku terpilih");

        btnHapus.setBackground(new java.awt.Color(231, 76, 60));
        btnHapus.setForeground(java.awt.Color.WHITE);
        btnHapus.setFocusPainted(false);
        btnHapus.setBorderPainted(false);
        btnHapus.setToolTipText("Hapus data buku terpilih");

        btnReset.setBackground(new java.awt.Color(149, 165, 166));
        btnReset.setForeground(java.awt.Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setBorderPainted(false);
        btnReset.setToolTipText("Reset form");

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

        try {

            Connection c =
                    Koneksi.getConnection();

            Statement s =
                    c.createStatement();

            ResultSet r =
                    s.executeQuery(
                            "SELECT * FROM buku"
                    );

            while(r.next()) {

                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("judul"),

                    r.getString("pengarang"),

                    r.getString("penerbit"),

                    r.getString("tahun"),

                    r.getString("stok")
                });
            }

            tableBuku.setModel(model);

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }
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

    try {

        String keyword =
                txtCari.getText();

        String sql =
                "SELECT * FROM buku "
                + "WHERE judul LIKE ? "
                + "OR pengarang LIKE ? "
                + "OR penerbit LIKE ?";

        Connection c =
                Koneksi.getConnection();

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

                r.getString("judul"),

                r.getString("pengarang"),

                r.getString("penerbit"),

                r.getString("tahun"),

                r.getString("stok")
            });
        }

        tableBuku.setModel(model);

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );
    }
}
    // =====================================
    // RESET FORM
    // =====================================

    private void resetForm() {

        txtJudul.setText("");

        txtPengarang.setText("");

        txtPenerbit.setText("");

        txtTahun.setText("");

        txtStok.setText("");

        tableBuku.clearSelection();

        btnEdit.setEnabled(false);

        btnHapus.setEnabled(false);
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
        txtTahun = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        lblPengarang = new javax.swing.JLabel();
        lblPenerbit = new javax.swing.JLabel();
        lblTahun = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();

        lblCari.setText("Cari Buku:");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        lblJudul.setText("Judul: ");

        txtPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPengarangActionPerformed(evt);
            }
        });

        txtPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenerbitActionPerformed(evt);
            }
        });

        txtTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTahunActionPerformed(evt);
            }
        });

        lblPengarang.setText("Pengarang: ");

        lblPenerbit.setText("Penerbit: ");

        lblTahun.setText("Tahun:");

        lblStok.setText("Stok: ");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tableBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBuku);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblPengarang)
                                            .addComponent(lblPenerbit, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(lblJudul, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(lblStok, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(lblCari, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblTahun))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTahun)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCari)
                            .addComponent(txtJudul)
                            .addComponent(txtPengarang, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                            .addComponent(txtPenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                            .addComponent(txtStok, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
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
                    .addComponent(txtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTahun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStok))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPengarangActionPerformed

    private void txtPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenerbitActionPerformed

    private void txtTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTahunActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        try {

            String judul =
                    txtJudul.getText();

            String pengarang =
                    txtPengarang.getText();

            String penerbit =
                    txtPenerbit.getText();

            String tahun =
                    txtTahun.getText();

            String stok =
                    txtStok.getText();

            if(judul.isEmpty() ||
               stok.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Judul dan stok wajib diisi"
                );

                return;
            }

            String sql =
                    "INSERT INTO buku("
                    + "judul,"
                    + "pengarang,"
                    + "penerbit,"
                    + "tahun,"
                    + "stok"
                    + ") VALUES(?,?,?,?,?)";

            Connection c =
                    Koneksi.getConnection();

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(1, judul);

            p.setString(2, pengarang);

            p.setString(3, penerbit);

            p.setString(4, tahun);

            p.setString(5, stok);

            p.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Buku berhasil ditambahkan"
            );

            loadTable();

            resetForm();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try {

            int baris =
                    tableBuku.getSelectedRow();

            String id =
                    tableBuku.getValueAt(baris, 0)
                    .toString();

            String sql =
                    "UPDATE buku SET "
                    + "judul=?,"
                    + "pengarang=?,"
                    + "penerbit=?,"
                    + "tahun=?,"
                    + "stok=? "
                    + "WHERE id=?";

            Connection c =
                    Koneksi.getConnection();

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(1, txtJudul.getText());

            p.setString(2, txtPengarang.getText());

            p.setString(3, txtPenerbit.getText());

            p.setString(4, txtTahun.getText());

            p.setString(5, txtStok.getText());

            p.setString(6, id);

            p.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil diupdate"
            );

            loadTable();

            resetForm();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {

            int pilih =
                    JOptionPane.showConfirmDialog(
                            null,
                            "Yakin ingin hapus?",
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION
                    );

            if(pilih != JOptionPane.YES_OPTION) {

                return;
            }

            int baris =
                    tableBuku.getSelectedRow();

            String id =
                    tableBuku.getValueAt(baris, 0)
                    .toString();

            String sql =
                    "DELETE FROM buku "
                    + "WHERE id=?";

            Connection c =
                    Koneksi.getConnection();

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(1, id);

            p.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil dihapus"
            );

            loadTable();

            resetForm();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBukuMouseClicked
        // TODO add your handling code here:
        int baris =
                tableBuku.getSelectedRow();

        txtJudul.setText(
                tableBuku.getValueAt(baris, 1)
                .toString()
        );

        txtPengarang.setText(
                tableBuku.getValueAt(baris, 2)
                .toString()
        );

        txtPenerbit.setText(
                tableBuku.getValueAt(baris, 3)
                .toString()
        );

        txtTahun.setText(
                tableBuku.getValueAt(baris, 4)
                .toString()
        );

        txtStok.setText(
                tableBuku.getValueAt(baris, 5)
                .toString()
        );

        btnEdit.setEnabled(true);

        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tableBukuMouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblPenerbit;
    private javax.swing.JLabel lblPengarang;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblTahun;
    private javax.swing.JTable tableBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtTahun;
    // End of variables declaration//GEN-END:variables
}

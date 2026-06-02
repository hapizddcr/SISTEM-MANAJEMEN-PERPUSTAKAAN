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

        try {

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT f.id, "
                    + "b.judul, "
                    + "b.pengarang, "
                    + "b.penerbit, "
                    + "b.tahun "
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

                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("judul"),

                    r.getString("pengarang"),

                    r.getString("penerbit"),

                    r.getString("tahun")
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

        try {

            String keyword =
                    txtCari.getText();

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT f.id, "
                    + "b.judul, "
                    + "b.pengarang, "
                    + "b.penerbit, "
                    + "b.tahun "
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

                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("judul"),

                    r.getString("pengarang"),

                    r.getString("penerbit"),

                    r.getString("tahun")
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
                            .addComponent(lblJudul)
                            .addComponent(lblPengarang)
                            .addComponent(lblPenerbit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHapus)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCari)
                            .addComponent(txtJudul)
                            .addComponent(txtPengarang, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(txtPenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblPenerbit;
    private javax.swing.JLabel lblPengarang;
    private javax.swing.JTable tableFavorit;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    // End of variables declaration//GEN-END:variables
}

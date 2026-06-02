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
public class PanelPeminjamanUser extends javax.swing.JPanel {

    /**
     * Creates new form PanelPeminjamanUser
     */
    public PanelPeminjamanUser() {
        initComponents();
        loadTable();

        txtBuku.setEditable(false);

        txtStatus.setEditable(false);

        txtTanggal.setEditable(false);
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
        model.addColumn("Buku");
        model.addColumn("Tanggal Pinjam");
        model.addColumn("Tanggal Kembali");
        model.addColumn("Status");

        try {

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT p.id, "
                    + "b.judul, "
                    + "p.tanggal_pinjam, "
                    + "p.tanggal_kembali, "
                    + "p.status "
                    + "FROM peminjaman p "
                    + "JOIN detail_peminjaman d "
                    + "ON p.id=d.peminjaman_id "
                    + "JOIN buku b "
                    + "ON d.buku_id=b.id "
                    + "WHERE p.user_id=?";

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
                    + "b.judul, "
                    + "p.tanggal_pinjam, "
                    + "p.tanggal_kembali, "
                    + "p.status "
                    + "FROM peminjaman p "
                    + "JOIN detail_peminjaman d "
                    + "ON p.id=d.peminjaman_id "
                    + "JOIN buku b "
                    + "ON d.buku_id=b.id "
                    + "WHERE p.user_id=? "
                    + "AND ("
                    + "b.judul LIKE ? "
                    + "OR p.status LIKE ?"
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

            ResultSet r =
                    p.executeQuery();

            while(r.next()) {

                model.addRow(new Object[] {

                    r.getString("id"),

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
        lblBuku = new javax.swing.JLabel();
        txtBuku = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePeminjaman = new javax.swing.JTable();

        lblCari.setText("Cari Peminjaman:");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        lblBuku.setText("Buku: ");

        lblStatus.setText("Status: ");

        lblTanggal.setText("Tanggal: ");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCari)
                            .addComponent(lblBuku)
                            .addComponent(lblStatus)
                            .addComponent(lblTanggal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCari)
                            .addComponent(txtBuku)
                            .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(txtTanggal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanggal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablePeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePeminjamanMouseClicked
        // TODO add your handling code here:
         int baris =
                tablePeminjaman.getSelectedRow();

        txtBuku.setText(
                tablePeminjaman.getValueAt(baris, 1)
                .toString()
        );

        txtTanggal.setText(
                tablePeminjaman.getValueAt(baris, 2)
                .toString()
        );

        txtStatus.setText(
                tablePeminjaman.getValueAt(baris, 4)
                .toString()
        );
    }//GEN-LAST:event_tablePeminjamanMouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuku;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTable tablePeminjaman;
    private javax.swing.JTextField txtBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}

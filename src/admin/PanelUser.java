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

import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author hapiz
 */
public class PanelUser extends javax.swing.JPanel {

    /**
     * Creates new form PanelUser
     */
    public PanelUser() {
        initComponents();
        loadTable();

        btnEdit.setEnabled(false);

        btnDelete.setEnabled(false);

        setBackground(java.awt.Color.WHITE);

        java.awt.Font boldLabel = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12);
        for (javax.swing.JLabel lb : new javax.swing.JLabel[]{
            lblCari, lblNamaLengkap, lblUser, lblPassword,
            lblNoHp, lblAlamat, lblRole, lblStatus
        }) {
            lb.setFont(boldLabel);
        }

        btnTambah.setBackground(new java.awt.Color(52, 152, 219));
        btnTambah.setForeground(java.awt.Color.WHITE);
        btnTambah.setFocusPainted(false);
        btnTambah.setBorderPainted(false);
        btnTambah.setToolTipText("Tambah user baru");

        btnEdit.setBackground(new java.awt.Color(243, 156, 18));
        btnEdit.setForeground(java.awt.Color.WHITE);
        btnEdit.setFocusPainted(false);
        btnEdit.setBorderPainted(false);
        btnEdit.setToolTipText("Edit data user terpilih");

        btnDelete.setBackground(new java.awt.Color(231, 76, 60));
        btnDelete.setForeground(java.awt.Color.WHITE);
        btnDelete.setFocusPainted(false);
        btnDelete.setBorderPainted(false);
        btnDelete.setToolTipText("Hapus user terpilih");

        btnReset.setBackground(new java.awt.Color(149, 165, 166));
        btnReset.setForeground(java.awt.Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setBorderPainted(false);
        btnReset.setToolTipText("Reset form");

        txtCari.setToolTipText("Cari berdasarkan nama atau username");
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
        model.addColumn("Nama Lengkap");
        model.addColumn("Username");
        model.addColumn("No HP");
        model.addColumn("Alamat");
        model.addColumn("Role");
        model.addColumn("Status");

        try {

            Connection c =
                    Koneksi.getConnection();

            Statement s =
                    c.createStatement();

            ResultSet r =
                    s.executeQuery(
                            "SELECT * FROM users"
                    );

            while(r.next()) {

                model.addRow(new Object[] {

                    r.getString("id"),

                    r.getString("nama_lengkap"),

                    r.getString("username"),

                    r.getString("no_hp"),

                    r.getString("alamat"),

                    r.getString("role"),

                    r.getString("status")
                });
            }

            tableUser.setModel(model);

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
        model.addColumn("Nama Lengkap");
        model.addColumn("Username");
        model.addColumn("No HP");
        model.addColumn("Alamat");
        model.addColumn("Role");
        model.addColumn("Status");

        try {

            String keyword =
                    txtCari.getText();

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "SELECT * FROM users "
                    + "WHERE nama_lengkap LIKE ? "
                    + "OR username LIKE ?";

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

                    r.getString("username"),

                    r.getString("no_hp"),

                    r.getString("alamat"),

                    r.getString("role"),

                    r.getString("status")
                });
            }

            tableUser.setModel(model);

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

        txtNama.setText("");

        txtUsername.setText("");

        txtPassword.setText("");

        txtNoHp.setText("");

        txtAlamat.setText("");

        cbRole.setSelectedIndex(-1);

        cbStatus.setSelectedIndex(-1);

        tableUser.clearSelection();

        btnEdit.setEnabled(false);

        btnDelete.setEnabled(false);
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
        lblNamaLengkap = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        cbShowPassword = new javax.swing.JCheckBox();
        lblNoHp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        lblAlamat = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        lblRole = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();

        lblCari.setText("Cari User: ");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        lblNamaLengkap.setText("Nama Lengkap: ");

        lblUser.setText("Username: ");

        txtNoHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoHpActionPerformed(evt);
            }
        });

        lblPassword.setText("Password: ");

        cbShowPassword.setText("Show Password");
        cbShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPasswordActionPerformed(evt);
            }
        });

        lblNoHp.setText("No Hp:");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        lblAlamat.setText("Alamat: ");

        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        cbRole.setSelectedIndex(-1);

        lblRole.setText("Role: ");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aktif", "nonaktif" }));
        cbStatus.setSelectedIndex(-1);

        lblStatus.setText("Status: ");

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

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
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
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNamaLengkap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNama))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblPassword))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbShowPassword)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoHp)
                            .addComponent(lblAlamat)
                            .addComponent(lblRole)
                            .addComponent(lblStatus))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(txtNoHp, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(cbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaLengkap)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword))
                        .addGap(4, 4, 4)
                        .addComponent(cbShowPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoHp))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlamat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHpActionPerformed

    private void cbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPasswordActionPerformed
        // TODO add your handling code here:
        if(cbShowPassword.isSelected()) {

        txtPassword.setEchoChar((char) 0);

    } else {

        txtPassword.setEchoChar('*');
    }
    }//GEN-LAST:event_cbShowPasswordActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {

        int baris =
                tableUser.getSelectedRow();

        if(baris == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih user terlebih dahulu"
            );

            return;
        }

        int pilih =
                JOptionPane.showConfirmDialog(
                        null,
                        "Yakin ingin menghapus user?",
                        "Konfirmasi Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if(pilih != JOptionPane.YES_OPTION) {

            return;
        }

        String id =
                tableUser.getValueAt(baris, 0)
                .toString();

        Connection c =
                Koneksi.getConnection();

        String sql =
                "DELETE FROM users "
                + "WHERE id=?";

        PreparedStatement p =
                c.prepareStatement(sql);

        p.setString(1, id);

        p.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "User berhasil dihapus"
        );

        loadTable();

        resetForm();

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        try {

            String nama =
                    txtNama.getText();

            String username =
                    txtUsername.getText()
                    .toLowerCase();

            String password =
                    txtPassword.getText();

            String noHp =
                    txtNoHp.getText();

            String alamat =
                    txtAlamat.getText();

            String role =
                    cbRole.getSelectedItem()
                    .toString();

            String status =
                    cbStatus.getSelectedItem()
                    .toString();

            // VALIDASI

            if(nama.isEmpty() ||
               username.isEmpty() ||
               password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Data wajib diisi"
                );

                return;
            }

            // VALIDASI NO HP

            if(!noHp.matches("[0-9]+")) {

                JOptionPane.showMessageDialog(
                        null,
                        "No HP hanya angka"
                );

                return;
            }

            Connection c =
                    Koneksi.getConnection();

            // CEK USERNAME

            String cek =
                    "SELECT * FROM users "
                    + "WHERE username=?";

            PreparedStatement pCek =
                    c.prepareStatement(cek);

            pCek.setString(1, username);

            ResultSet r =
                    pCek.executeQuery();

            if(r.next()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Username sudah digunakan"
                );

                return;
            }

            // HASH PASSWORD

            String hashPassword =
                    BCrypt.hashpw(
                            password,
                            BCrypt.gensalt()
                    );

            // INSERT

            String sql =
                    "INSERT INTO users("
                    + "nama_lengkap,"
                    + "username,"
                    + "password,"
                    + "no_hp,"
                    + "alamat,"
                    + "role,"
                    + "status"
                    + ") VALUES(?,?,?,?,?,?,?)";

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(1, nama);

            p.setString(2, username);

            p.setString(3, hashPassword);

            p.setString(4, noHp);

            p.setString(5, alamat);

            p.setString(6, role);

            p.setString(7, status);

            p.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "User berhasil ditambahkan"
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

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        // TODO add your handling code here:
        int baris =
                tableUser.getSelectedRow();

        txtNama.setText(
                tableUser.getValueAt(baris, 1)
                .toString()
        );

        txtUsername.setText(
                tableUser.getValueAt(baris, 2)
                .toString()
        );

        txtNoHp.setText(
                tableUser.getValueAt(baris, 3)
                .toString()
        );

        txtAlamat.setText(
                tableUser.getValueAt(baris, 4)
                .toString()
        );

        cbRole.setSelectedItem(
                tableUser.getValueAt(baris, 5)
                .toString()
        );

        cbStatus.setSelectedItem(
                tableUser.getValueAt(baris, 6)
                .toString()
        );

        btnEdit.setEnabled(true);

        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tableUserMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try {

            int baris =
                    tableUser.getSelectedRow();

            String id =
                    tableUser.getValueAt(baris, 0)
                    .toString();

            Connection c =
                    Koneksi.getConnection();

            String sql =
                    "UPDATE users SET "
                    + "nama_lengkap=?, "
                    + "username=?, "
                    + "no_hp=?, "
                    + "alamat=?, "
                    + "role=?, "
                    + "status=? "
                    + "WHERE id=?";

            PreparedStatement p =
                    c.prepareStatement(sql);

            p.setString(
                    1,
                    txtNama.getText()
            );

            p.setString(
                    2,
                    txtUsername.getText()
            );

            p.setString(
                    3,
                    txtNoHp.getText()
            );

            p.setString(
                    4,
                    txtAlamat.getText()
            );

            p.setString(
                    5,
                    cbRole.getSelectedItem()
                    .toString()
            );

            p.setString(
                    6,
                    cbStatus.getSelectedItem()
                    .toString()
            );

            p.setString(7, id);

            p.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "User berhasil diupdate"
            );

            int reset = JOptionPane.showConfirmDialog(
                    null,
                    "Reset password user ini?",
                    "Reset Password",
                    JOptionPane.YES_NO_OPTION
            );

            if(reset == JOptionPane.YES_OPTION) {
                String passBaru = JOptionPane.showInputDialog(
                        null,
                        "Masukkan password baru:",
                        "Reset Password",
                        JOptionPane.PLAIN_MESSAGE
                );

                if(passBaru != null && !passBaru.trim().isEmpty()) {
                    String hash = BCrypt.hashpw(passBaru, BCrypt.gensalt());
                    String sqlPass = "UPDATE users SET password=? WHERE id=?";
                    PreparedStatement pPass = c.prepareStatement(sqlPass);
                    pPass.setString(1, hash);
                    pPass.setString(2, id);
                    pPass.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Password berhasil direset");
                }
            }

            loadTable();

            resetForm();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JCheckBox cbShowPassword;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblNamaLengkap;
    private javax.swing.JLabel lblNoHp;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

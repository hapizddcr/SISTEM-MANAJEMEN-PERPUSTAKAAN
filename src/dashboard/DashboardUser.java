/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dashboard;
import auth.Login;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import session.Session;

import user.PanelBukuUser;
import user.PanelDashboardUser;
import user.PanelFavorit;
import user.PanelPeminjamanUser;
import user.PanelProfil;
import java.awt.Dimension;
import java.awt.Font;
/**
 *
 * @author hapiz
 */
public class DashboardUser extends javax.swing.JFrame {

    /**
     * Creates new form DashboardUser
     */
    public DashboardUser() {
        initComponents();
        setLocationRelativeTo(null);

        btnDashboard.setText("Dashboard");
        btnBuku.setText("Buku");
        btnPeminjaman.setText("Peminjaman");
        btnFavorit.setText("Favorit");
        btnProfil.setText("Profil");
        btnLogout.setText("Logout");

        btnDashboard.setToolTipText("Dashboard utama");
        btnBuku.setToolTipText("Cari dan pinjam buku");
        btnPeminjaman.setToolTipText("Lihat riwayat peminjaman");
        btnFavorit.setToolTipText("Daftar buku favorit");
        btnProfil.setToolTipText("Edit profil");
        btnLogout.setToolTipText("Keluar dari sistem");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                int pilih = JOptionPane.showConfirmDialog(
                    null,
                    "Yakin ingin keluar?",
                    "Konfirmasi Keluar",
                    JOptionPane.YES_NO_OPTION
                );
                if(pilih == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        setMinimumSize(new Dimension(800, 600));

        lblNama.setText(
                "Selamat Datang, "
                +
                Session.role.toUpperCase()
                + " - "
                + Session.namaLengkap
        );

        panelHeader.setBackground(new java.awt.Color(52, 73, 94));
        lblTitle.setForeground(java.awt.Color.WHITE);
        lblNama.setForeground(java.awt.Color.WHITE);

        panelSidebar.setBackground(new java.awt.Color(44, 62, 80));
        jScrollPane2.setBackground(new java.awt.Color(44, 62, 80));
        jScrollPane2.getViewport().setBackground(new java.awt.Color(44, 62, 80));

        java.awt.Color inactiveBg = new java.awt.Color(44, 62, 80);
        java.awt.Color inactiveFg = java.awt.Color.WHITE;
        java.awt.Color activeBg = new java.awt.Color(41, 128, 185);

        for (javax.swing.JButton btn : new javax.swing.JButton[]{
            btnDashboard, btnBuku, btnPeminjaman,
            btnFavorit, btnProfil, btnLogout
        }) {
            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setBackground(inactiveBg);
            btn.setForeground(inactiveFg);
            if (btn == btnLogout) {
                btn.setBackground(new java.awt.Color(192, 57, 43));
            }
        }

        // SIDEBAR
        jScrollPane2.setPreferredSize(new java.awt.Dimension(180, 0));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // HEADER
        panelHeader.setPreferredSize(new java.awt.Dimension(0, 65));
        lblTitle.setFont(lblTitle.getFont().deriveFont(Font.BOLD, 20));
        lblNama.setFont(lblNama.getFont().deriveFont(Font.PLAIN, 14));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        // BUTTON HEIGHT
        java.awt.Dimension btnSize = new java.awt.Dimension(0, 36);
        for (javax.swing.JButton btn : new javax.swing.JButton[]{
            btnDashboard, btnBuku, btnPeminjaman,
            btnFavorit, btnProfil, btnLogout
        }) {
            btn.setPreferredSize(btnSize);
        }

        // CONTENT
        panelContent.setBackground(java.awt.Color.WHITE);

        setActiveButton(btnDashboard);

        loadPanel(
                new PanelDashboardUser()
        );
    }

    private void setActiveButton(javax.swing.JButton active) {
        java.awt.Color inactiveBg = new java.awt.Color(44, 62, 80);
        java.awt.Color activeBg = new java.awt.Color(41, 128, 185);
        for (javax.swing.JButton btn : new javax.swing.JButton[]{
            btnDashboard, btnBuku, btnPeminjaman,
            btnFavorit, btnProfil, btnLogout
        }) {
            btn.setBackground(btn == active ? activeBg : inactiveBg);
        }
    }
    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            setExtendedState(MAXIMIZED_BOTH);
        }
        super.setVisible(visible);
    }
    public void loadPanel(JPanel panel) {

        panelContent.removeAll();

        panelContent.add(panel);

        panelContent.repaint();

        panelContent.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelContent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelSidebar = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnBuku = new javax.swing.JButton();
        btnPeminjaman = new javax.swing.JButton();
        btnProfil = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnFavorit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Sistem Manajemen Perpustakaan");

        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNama.setText("Nama");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNama)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelContent.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(panelContent);

        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnBuku.setText("Buku");
        btnBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBukuActionPerformed(evt);
            }
        });

        btnPeminjaman.setText("Peminjaman");
        btnPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeminjamanActionPerformed(evt);
            }
        });

        btnProfil.setText("Profil");
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnFavorit.setText("Favorit");
        btnFavorit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoritActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFavorit, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPeminjaman)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFavorit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfil)
                .addGap(93, 93, 93)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(panelSidebar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        setActiveButton(btnDashboard);
        loadPanel(
            new PanelDashboardUser()
        );
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBukuActionPerformed
        // TODO add your handling code here:
        setActiveButton(btnBuku);
        loadPanel(
            new PanelBukuUser()
        );
    }//GEN-LAST:event_btnBukuActionPerformed

    private void btnPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeminjamanActionPerformed
        // TODO add your handling code here:
        setActiveButton(btnPeminjaman);
        loadPanel(
            new PanelPeminjamanUser()
        );
    }//GEN-LAST:event_btnPeminjamanActionPerformed

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        // TODO add your handling code here:
        setActiveButton(btnProfil);
        loadPanel(
            new PanelProfil()
        );
    }//GEN-LAST:event_btnProfilActionPerformed

    private void btnFavoritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoritActionPerformed
        // TODO add your handling code here:
        setActiveButton(btnFavorit);
        loadPanel(
                new PanelFavorit()
        );
    }//GEN-LAST:event_btnFavoritActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        setActiveButton(btnLogout);
        int pilih =
        JOptionPane.showConfirmDialog(
            null,
            "Yakin ingin logout?",
            "Konfirmasi Logout",
            JOptionPane.YES_NO_OPTION
        );

        if(pilih == JOptionPane.YES_OPTION) {
            Session.idUser = 0;

            Session.username = null;

            Session.role = null;

            Session.namaLengkap = null;
            dispose();

            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuku;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnFavorit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPeminjaman;
    private javax.swing.JButton btnProfil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelSidebar;
    // End of variables declaration//GEN-END:variables
}

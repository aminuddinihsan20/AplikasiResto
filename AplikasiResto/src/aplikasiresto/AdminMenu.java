/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiresto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author zidan
 */
public class AdminMenu extends javax.swing.JFrame {
    public static int statusSearching = 0;
    private final Connection conn=new koneksiDB().connect();
    private DefaultTableModel tabmode;
    private Object stat;
    public TableCellRenderer tengah = new Rendering_tengah();
    public TableCellRenderer kanan = new Rendering_kanan();

    public AdminMenu() {
        initComponents();
        aktif();
        autonomor();
        datatabel();
        lebarKolom();
        perataan();
    }
    
    protected void aktif(){ 
        kodeAdmin.setEnabled(false);
        namaAdmin.setEnabled(true);
        noTelpAdmin.setEnabled(true);
        alamatAdmin.setEnabled(true); 
    }
        
    public void kosong(){
        namaAdmin.setText("");
        noTelpAdmin.setText("");
        alamatAdmin.setText("");
    }
    
    private void autonomor(){
            String sql = "select max(KodeAdmin) from tb_admin";
            try{
                Statement stat = conn.createStatement();
                ResultSet rs= stat.executeQuery(sql);
                while (rs.next()){
                    int a = rs.getInt(1);
                    kodeAdmin.setText( Integer.toString(a+1));
                }
            }catch (Exception e){
                System.out.println(""+ e.getMessage());
            }

    }
    
    protected void datatabel(){
            Object[] baris = {"Kode Admin","Nama Admin","No Telpon","Alamat","Username","Password"};
            tabmode = new DefaultTableModel(null, baris);
            tableAdmin.setModel(tabmode);
            String sql = "select * from tb_admin";
            try{
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String kodeAdmin = hasil.getString("KodeAdmin");
                    String namaAdmin = hasil.getString("NamaAdmin");
                    String noTelpAdmin = hasil.getString("NoTelpAdmin");
                    String alamatAdmin = hasil.getString("Alamat");
                    String userAdmin = hasil.getString("Username");
                    String passAdmin = hasil.getString("Password");


                    String[] data = {kodeAdmin,namaAdmin,noTelpAdmin,alamatAdmin,userAdmin,passAdmin};
                    tabmode.addRow(data);
                } 
            }   catch (SQLException ex) {
                Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    public void lebarKolom(){ 
            TableColumn column;
            column = tableAdmin.getColumnModel().getColumn(0); 
            column.setPreferredWidth(30);
            column = tableAdmin.getColumnModel().getColumn(1); 
            column.setPreferredWidth(70);
            column = tableAdmin.getColumnModel().getColumn(2); 
            column.setPreferredWidth(60);
            column = tableAdmin.getColumnModel().getColumn(3); 
            column.setPreferredWidth(50);
            column = tableAdmin.getColumnModel().getColumn(4); 
            column.setPreferredWidth(60);
            column = tableAdmin.getColumnModel().getColumn(5); 
            column.setPreferredWidth(50);
        }
        
        public void perataan(){
            tableAdmin.getColumnModel().getColumn(0).setCellRenderer(tengah);
            tableAdmin.getColumnModel().getColumn(1).setCellRenderer(tengah);
            tableAdmin.getColumnModel().getColumn(2).setCellRenderer(tengah);
            tableAdmin.getColumnModel().getColumn(3).setCellRenderer(tengah);
            tableAdmin.getColumnModel().getColumn(4).setCellRenderer(tengah);
            tableAdmin.getColumnModel().getColumn(5).setCellRenderer(tengah);

        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAdmin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        kodeAdmin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namaAdmin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        noTelpAdmin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        alamatAdmin = new javax.swing.JTextField();
        tombolBuat = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        userAdmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passAdmin = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        Kasir = new javax.swing.JButton();
        Pembayaran = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Admin", "Nama Admin", "No Telpon", "Alamat", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAdmin.setPreferredSize(new java.awt.Dimension(800, 600));
        tableAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAdmin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 60, -1, -1));

        jLabel1.setText("Kode Admin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 63, -1, -1));

        kodeAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeAdminActionPerformed(evt);
            }
        });
        getContentPane().add(kodeAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 60, 107, -1));

        jLabel2.setText("Nama Admin");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 103, -1, -1));

        namaAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaAdminActionPerformed(evt);
            }
        });
        getContentPane().add(namaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 100, 107, -1));

        jLabel3.setText("No Telpon");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 143, -1, -1));
        getContentPane().add(noTelpAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 140, 107, -1));

        jLabel4.setText("Alamat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 183, -1, -1));
        getContentPane().add(alamatAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 180, 107, -1));

        tombolBuat.setText("Buat");
        tombolBuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBuatActionPerformed(evt);
            }
        });
        getContentPane().add(tombolBuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 303, -1, -1));

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });
        getContentPane().add(tombolUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 303, -1, -1));

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });
        getContentPane().add(tombolHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 303, -1, -1));

        jButton1.setText("Menu Minuman");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel5.setText("Tombol Navigasi ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, 20));

        jButton2.setText("Menu Makanan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 223, -1, -1));
        getContentPane().add(userAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 220, 107, -1));

        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 263, -1, -1));
        getContentPane().add(passAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 260, 107, -1));

        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 19, -1, -1));

        Kasir.setText("Kasir");
        Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KasirActionPerformed(evt);
            }
        });
        getContentPane().add(Kasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        Pembayaran.setText("Pembayaran");
        Pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PembayaranActionPerformed(evt);
            }
        });
        getContentPane().add(Pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));

        jButton3.setText("Pesanan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaAdminActionPerformed

    private void kodeAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeAdminActionPerformed

    private void tombolBuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBuatActionPerformed
        if(kodeAdmin.getText().equals("")||namaAdmin.getText().equals("")||noTelpAdmin.getText().equals("")||alamatAdmin.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Jangan ada data kosong !","Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sql = "insert into tb_admin values(?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kodeAdmin.getText());
            stat.setString(2, namaAdmin.getText());
            stat.setString(3, noTelpAdmin.getText());
            stat.setString(4, alamatAdmin.getText());
            stat.setString(5, userAdmin.getText());
            stat.setString(6, passAdmin.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambah");

 
            datatabel();
            perataan();
            lebarKolom();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" +e);
        }
    }//GEN-LAST:event_tombolBuatActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        String sql = "update tb_admin set Nama_Admin=?, No_Telp=?, Alamat=?, Username=?, Password =? where Kode_Admin= "+kodeAdmin.getText()+"";
        
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaAdmin.getText());
            stat.setString(2, noTelpAdmin.getText());
            stat.setString(3, alamatAdmin.getText());
            stat.setString(4, userAdmin.getText());
            stat.setString(5, passAdmin.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate");
            kosong();
            kodeAdmin.requestFocus();
            datatabel();
            perataan();
            lebarKolom();
            autonomor();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Diupdate" +e);
        }
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah ada yakin ingin menghapus data", "Konfirmasi Dialog",
            JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "delete from admin where Kode_Admin='"+kodeAdmin.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");

                //jamJP.requestFocus();
                datatabel();
                kosong();
                autonomor();
                lebarKolom();
                perataan();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus" +e);
            }
        }
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tableAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAdminMouseClicked
        // TODO add your handling code here:
        kodeAdmin.setText(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 0).toString());
        try {
            // TODO add your handling code here:
            int index = tableAdmin.getSelectedRow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        namaAdmin.setText(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 1).toString());           
        noTelpAdmin.setText(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 2).toString());
        alamatAdmin.setText(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 3).toString());
        userAdmin.setText(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 4).toString());
        passAdmin.setText(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tableAdminMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new EditMakanan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new EditMinuman().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int pesan = JOptionPane.showConfirmDialog(null, "Yakin akan log out?", "Konfirmasi", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION)
        {
            new Login().setVisible(true);
         
        }    
    }//GEN-LAST:event_jButton7ActionPerformed

    private void KasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KasirActionPerformed
        // TODO add your handling code here:
        new Kasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_KasirActionPerformed

    private void PembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PembayaranActionPerformed
        // TODO add your handling code here:
        new Pembayaran().setVisible(true);
        dispose();
    }//GEN-LAST:event_PembayaranActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new PesanMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kasir;
    private javax.swing.JButton Pembayaran;
    private javax.swing.JTextField alamatAdmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodeAdmin;
    private javax.swing.JTextField namaAdmin;
    private javax.swing.JTextField noTelpAdmin;
    private javax.swing.JTextField passAdmin;
    private javax.swing.JTable tableAdmin;
    private javax.swing.JButton tombolBuat;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolUbah;
    private javax.swing.JTextField userAdmin;
    // End of variables declaration//GEN-END:variables
}

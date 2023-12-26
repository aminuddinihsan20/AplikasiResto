/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasiresto;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
public class EditMakanan extends javax.swing.JFrame {
    public static int statusSearching = 0;
    private final Connection conn=new koneksiDB().connect();
    private DefaultTableModel tabmode;
    private Object stat;
    public TableCellRenderer tengah = new Rendering_tengah();
    public TableCellRenderer kanan = new Rendering_kanan();
    /**
     * Creates new form EditMakanan
     */
    public EditMakanan() {
        initComponents();
        aktif();
        autonomor();
        datatabel();
        lebarKolom();
        perataan();
    }
    protected void aktif(){ 
        kodeMakanan.setEnabled(false);
        namaMakanan.setEnabled(true);
        hargaMakanan.setEnabled(true);
        stokMakanan.setEnabled(true);
        //jamJP.requestFocus();
 
    }
        
    public void kosong(){
        namaMakanan.setText("");
        hargaMakanan.setText("");
        stokMakanan.setText("");
    }
    
    private void autonomor(){
            String sql = "select max(kodeMakanan) from makanan";
            try{
                Statement stat = conn.createStatement();
                ResultSet rs= stat.executeQuery(sql);
                while (rs.next()){
                    int a = rs.getInt(1);
                    kodeMakanan.setText( Integer.toString(a+1));
                }
            }catch (Exception e){
                System.out.println(""+ e.getMessage());
            }

    }
     protected void datatabel(){
            Object[] baris = {"Kode Makanan","Nama Makanan","Harga","Stok Makanan"};
            tabmode = new DefaultTableModel(null, baris);
            tableMenuMakanan.setModel(tabmode);
            String sql = "select * from makanan";
            try{
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String kodeMakanan = hasil.getString("KodeMakanan");
                    String namaMakanan = hasil.getString("Nama_Makanan");
                    String hargaMakanan = hasil.getString("Harga");
                    String stokMakanan = hasil.getString("StokMakanan");


                    String[] data = {kodeMakanan,namaMakanan,hargaMakanan,stokMakanan};
                    tabmode.addRow(data);
                } 
            }   catch (SQLException ex) {
                Logger.getLogger(EditMakanan.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    public void lebarKolom(){ 
            TableColumn column;
            column = tableMenuMakanan.getColumnModel().getColumn(0); 
            column.setPreferredWidth(30);
            column = tableMenuMakanan.getColumnModel().getColumn(1); 
            column.setPreferredWidth(70);
            column = tableMenuMakanan.getColumnModel().getColumn(2); 
            column.setPreferredWidth(60);
            column = tableMenuMakanan.getColumnModel().getColumn(3); 
            column.setPreferredWidth(50);
        }
        
        public void perataan(){
            tableMenuMakanan.getColumnModel().getColumn(0).setCellRenderer(tengah);
            tableMenuMakanan.getColumnModel().getColumn(1).setCellRenderer(tengah);
            tableMenuMakanan.getColumnModel().getColumn(2).setCellRenderer(tengah);
            tableMenuMakanan.getColumnModel().getColumn(3).setCellRenderer(tengah);

        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        kodeMakanan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namaMakanan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hargaMakanan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stokMakanan = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        tombolBuat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenuMakanan = new javax.swing.JTable();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Kasir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Minuman");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        kodeMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeMakananActionPerformed(evt);
            }
        });
        getContentPane().add(kodeMakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 83, 107, -1));

        jLabel5.setText("Tombol Navigasi ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 320, -1, -1));

        jLabel2.setText("Nama Makanan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 126, -1, -1));

        namaMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaMakananActionPerformed(evt);
            }
        });
        getContentPane().add(namaMakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 123, 107, -1));

        jLabel3.setText("Harga");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 166, -1, -1));
        getContentPane().add(hargaMakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 163, 107, -1));

        jLabel4.setText("Stok Makanan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 206, -1, -1));
        getContentPane().add(stokMakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 203, 107, -1));

        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 36, -1, -1));

        tombolBuat.setText("Buat");
        tombolBuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBuatActionPerformed(evt);
            }
        });
        getContentPane().add(tombolBuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 260, -1, -1));

        tableMenuMakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Makanan", "Nama Makanan", "Harga", "Stok Makanan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenuMakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuMakananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMenuMakanan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 77, -1, -1));

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });
        getContentPane().add(tombolUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 260, -1, -1));

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });
        getContentPane().add(tombolHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 260, -1, -1));

        jLabel1.setText("Kode Makanan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 86, -1, -1));

        Kasir.setText("Kasir");
        Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KasirActionPerformed(evt);
            }
        });
        getContentPane().add(Kasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 389, -1, -1));

        jButton2.setText("Admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new EditMinuman().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kodeMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeMakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeMakananActionPerformed

    private void namaMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaMakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaMakananActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int pesan = JOptionPane.showConfirmDialog(null, "Yakin akan log out?", "Konfirmasi", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION)
        {
            new Login().setVisible(true);

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tombolBuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBuatActionPerformed
        if(kodeMakanan.getText().equals("")||namaMakanan.getText().equals("")||hargaMakanan.getText().equals("")||stokMakanan.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Jangan ada data kosong !","Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "insert into makanan values(?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kodeMakanan.getText());
            stat.setString(2, namaMakanan.getText());
            stat.setString(3, hargaMakanan.getText());
            stat.setString(4, stokMakanan.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambah");

            //jamJP.requestFocus();
            datatabel();
            perataan();
            lebarKolom();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" +e);
        }
    }//GEN-LAST:event_tombolBuatActionPerformed

    private void tableMenuMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMakananMouseClicked
        // TODO add your handling code here:
        kodeMakanan.setText(tableMenuMakanan.getValueAt(tableMenuMakanan.getSelectedRow(), 0).toString());
        try {
            // TODO add your handling code here:
            int index = tableMenuMakanan.getSelectedRow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        namaMakanan.setText(tableMenuMakanan.getValueAt(tableMenuMakanan.getSelectedRow(), 1).toString());
        hargaMakanan.setText(tableMenuMakanan.getValueAt(tableMenuMakanan.getSelectedRow(), 2).toString());
        stokMakanan.setText(tableMenuMakanan.getValueAt(tableMenuMakanan.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tableMenuMakananMouseClicked

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        String sql = "update makanan set Nama_Makanan=?, Harga=?, StokMakanan=? where kodeMakanan= "+kodeMakanan.getText()+"";

        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaMakanan.getText());
            stat.setString(2, hargaMakanan.getText());
            stat.setString(3, stokMakanan.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate");
            kosong();
            kodeMakanan.requestFocus();
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
            String sql = "delete from makanan where kodeMakanan='"+kodeMakanan.getText()+"'";
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

    private void KasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KasirActionPerformed
        // TODO add your handling code here:
        new Kasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_KasirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new AdminMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EditMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMakanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kasir;
    private javax.swing.JTextField hargaMakanan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodeMakanan;
    private javax.swing.JTextField namaMakanan;
    private javax.swing.JTextField stokMakanan;
    private javax.swing.JTable tableMenuMakanan;
    private javax.swing.JButton tombolBuat;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}

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
public class EditMinuman extends javax.swing.JFrame {
    public static int statusSearching = 0;
    private final Connection conn=new koneksiDB().connect();
    private DefaultTableModel tabmode;
    private Object stat;
    public TableCellRenderer tengah = new Rendering_tengah();
    public TableCellRenderer kanan = new Rendering_kanan();

    public EditMinuman() {
        initComponents();
        aktif();
        autonomor();
        datatabel();
        lebarKolom();
        perataan();
    }
    
    protected void aktif(){ 
        kodeMinuman.setEnabled(false);
        namaMinuman.setEnabled(true);
        hargaMinuman.setEnabled(true);
        stokMinuman.setEnabled(true);
        //jamJP.requestFocus();
 
    }
        
    public void kosong(){
        namaMinuman.setText("");
        hargaMinuman.setText("");
        stokMinuman.setText("");
    }
    
    private void autonomor(){
            String sql = "select max(KodeMinuman) from minuman";
            try{
                Statement stat = conn.createStatement();
                ResultSet rs= stat.executeQuery(sql);
                while (rs.next()){
                    int a = rs.getInt(1);
                    kodeMinuman.setText( Integer.toString(a+1));
                }
            }catch (Exception e){
                System.out.println(""+ e.getMessage());
            }

    }
    
    protected void datatabel(){
            Object[] baris = {"Kode Minuman","Nama Minuman","Harga","Stok Minuman"};
            tabmode = new DefaultTableModel(null, baris);
            tableMenuMinuman.setModel(tabmode);
            String sql = "select * from minuman";
            try{
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String kodeMinuman = hasil.getString("KodeMinuman");
                    String namaMinuman = hasil.getString("Nama_Minuman");
                    String hargaMinuman = hasil.getString("Harga");
                    String stokMinuman = hasil.getString("StokMinuman");


                    String[] data = {kodeMinuman,namaMinuman,hargaMinuman,stokMinuman};
                    tabmode.addRow(data);
                } 
            }   catch (SQLException ex) {
                Logger.getLogger(EditMinuman.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    public void lebarKolom(){ 
            TableColumn column;
            column = tableMenuMinuman.getColumnModel().getColumn(0); 
            column.setPreferredWidth(30);
            column = tableMenuMinuman.getColumnModel().getColumn(1); 
            column.setPreferredWidth(70);
            column = tableMenuMinuman.getColumnModel().getColumn(2); 
            column.setPreferredWidth(60);
            column = tableMenuMinuman.getColumnModel().getColumn(3); 
            column.setPreferredWidth(50);
        }
        
        public void perataan(){
            tableMenuMinuman.getColumnModel().getColumn(0).setCellRenderer(tengah);
            tableMenuMinuman.getColumnModel().getColumn(1).setCellRenderer(tengah);
            tableMenuMinuman.getColumnModel().getColumn(2).setCellRenderer(tengah);
            tableMenuMinuman.getColumnModel().getColumn(3).setCellRenderer(tengah);

        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenuMinuman = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        kodeMinuman = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namaMinuman = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hargaMinuman = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stokMinuman = new javax.swing.JTextField();
        tombolBuat = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Kasir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMenuMinuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Minuman", "Nama Minuman", "Harga", "Stok Minuman"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenuMinuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuMinumanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMenuMinuman);

        jLabel1.setText("Kode Minuman");

        kodeMinuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeMinumanActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Minuman");

        namaMinuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaMinumanActionPerformed(evt);
            }
        });

        jLabel3.setText("Harga");

        jLabel4.setText("Stok Minuman");

        tombolBuat.setText("Buat");
        tombolBuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBuatActionPerformed(evt);
            }
        });

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jButton1.setText("Makanan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Tombol Navigasi ");

        jButton2.setText("Admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        Kasir.setText("Kasir");
        Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KasirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(690, 690, 690)
                .addComponent(jButton7))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(kodeMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(namaMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(85, 85, 85)
                                .addComponent(hargaMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(39, 39, 39)
                                .addComponent(stokMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton1)
                                .addGap(41, 41, 41)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tombolBuat)
                                        .addGap(26, 26, 26)
                                        .addComponent(tombolUbah)))
                                .addGap(18, 18, 18)
                                .addComponent(tombolHapus)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Kasir)
                        .addGap(118, 118, 118)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(kodeMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(namaMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(hargaMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(stokMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tombolBuat)
                            .addComponent(tombolUbah)
                            .addComponent(tombolHapus))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Kasir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaMinumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaMinumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaMinumanActionPerformed

    private void kodeMinumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeMinumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeMinumanActionPerformed

    private void tombolBuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBuatActionPerformed
        if(kodeMinuman.getText().equals("")||namaMinuman.getText().equals("")||hargaMinuman.getText().equals("")||stokMinuman.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Jangan ada data kosong !","Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sql = "insert into minuman values(?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kodeMinuman.getText());
            stat.setString(2, namaMinuman.getText());
            stat.setString(3, hargaMinuman.getText());
            stat.setString(4, stokMinuman.getText());

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

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        String sql = "update minuman set Nama_Minuman=?, Harga=?, StokMinuman=? where KodeMinuman= "+kodeMinuman.getText()+"";
        
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaMinuman.getText());
            stat.setString(2, hargaMinuman.getText());
            stat.setString(3, stokMinuman.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate");
            kosong();
            kodeMinuman.requestFocus();
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
            String sql = "delete from minuman where KodeMinuman='"+kodeMinuman.getText()+"'";
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

    private void tableMenuMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMinumanMouseClicked
        // TODO add your handling code here:
        kodeMinuman.setText(tableMenuMinuman.getValueAt(tableMenuMinuman.getSelectedRow(), 0).toString());
        try {
            // TODO add your handling code here:
            int index = tableMenuMinuman.getSelectedRow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        namaMinuman.setText(tableMenuMinuman.getValueAt(tableMenuMinuman.getSelectedRow(), 1).toString());           
        hargaMinuman.setText(tableMenuMinuman.getValueAt(tableMenuMinuman.getSelectedRow(), 2).toString());
        stokMinuman.setText(tableMenuMinuman.getValueAt(tableMenuMinuman.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tableMenuMinumanMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new AdminMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new EditMakanan().setVisible(true);
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
            java.util.logging.Logger.getLogger(EditMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMinuman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kasir;
    private javax.swing.JTextField hargaMinuman;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodeMinuman;
    private javax.swing.JTextField namaMinuman;
    private javax.swing.JTextField stokMinuman;
    private javax.swing.JTable tableMenuMinuman;
    private javax.swing.JButton tombolBuat;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}

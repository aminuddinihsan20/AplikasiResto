package aplikasiresto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 * @author fajar
 */
public class Kasir extends javax.swing.JFrame {
    public static int statusSearching = 0;
    private final Connection conn=new koneksiDB().connect();
    private DefaultTableModel tabmode;
    private Object stat;
    public TableCellRenderer tengah = new Rendering_tengah();
    public TableCellRenderer kanan = new Rendering_kanan();

    public Kasir() {
        initComponents();
        aktif();
        autonomor();
        datatabel();
        lebarKolom();
        perataan();
    }
    
    protected void aktif(){ 
        kodeKasir.setEnabled(false);
        namaKasir.setEnabled(true);
        noTelpKasir.setEnabled(true);
        AlamatKasir.setEnabled(true);
        //jamJP.requestFocus();
 
    }
        
    public void kosong(){
        namaKasir.setText("");
        noTelpKasir.setText("");
        AlamatKasir.setText("");
    }
    
    private void autonomor(){
            String sql = "select max(Kode_Kasir) from tb_kasir";
            try{
                Statement stat = conn.createStatement();
                ResultSet rs= stat.executeQuery(sql);
                while (rs.next()){
                    int a = rs.getInt(1);
                    kodeKasir.setText( Integer.toString(a+1));
                }
            }catch (Exception e){
                System.out.println(""+ e.getMessage());
            }

    }
    
    protected void datatabel(){
            Object[] baris = {"Kode Kasir","Nama Kasir","No Telpon","Alamat"};
            tabmode = new DefaultTableModel(null, baris);
            tableMenuAdmin.setModel(tabmode);
            String sql = "select * from tb_kasir";
            try{
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String kodeKasir = hasil.getString("Kode_Kasir");
                    String namaKasir = hasil.getString("Nama_Kasir");
                    String noTelpKasir = hasil.getString("No_Telp");
                    String alamatKasir = hasil.getString("Alamat");


                    String[] data = {kodeKasir,namaKasir,noTelpKasir,alamatKasir};
                    tabmode.addRow(data);
                } 
            }   catch (SQLException ex) {
                Logger.getLogger(Kasir.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    public void lebarKolom(){ 
            TableColumn column;
            column = tableMenuAdmin.getColumnModel().getColumn(0); 
            column.setPreferredWidth(30);
            column = tableMenuAdmin.getColumnModel().getColumn(1); 
            column.setPreferredWidth(70);
            column = tableMenuAdmin.getColumnModel().getColumn(2); 
            column.setPreferredWidth(60);
            column = tableMenuAdmin.getColumnModel().getColumn(3); 
            column.setPreferredWidth(50);
        }
        
        public void perataan(){
            tableMenuAdmin.getColumnModel().getColumn(0).setCellRenderer(tengah);
            tableMenuAdmin.getColumnModel().getColumn(1).setCellRenderer(tengah);
            tableMenuAdmin.getColumnModel().getColumn(2).setCellRenderer(tengah);
            tableMenuAdmin.getColumnModel().getColumn(3).setCellRenderer(tengah);

        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenuAdmin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        kodeKasir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namaKasir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        noTelpKasir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AlamatKasir = new javax.swing.JTextField();
        tombolBuat = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Pembayaran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMenuAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Kasir", "Nama Kasir", "No Telpon", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenuAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMenuAdmin);

        jLabel1.setText("Kode Kasir");

        kodeKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeKasirActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama kasir");

        namaKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKasirActionPerformed(evt);
            }
        });

        jLabel3.setText("No Telpon");

        jLabel4.setText("Alamat");

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

        jButton1.setText("Menu Minuman");
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

        jButton3.setText("Menu Makanan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        Pembayaran.setText("Pembayaran");
        Pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PembayaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 32, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(kodeKasir)
                                            .addComponent(namaKasir)
                                            .addComponent(noTelpKasir)
                                            .addComponent(AlamatKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tombolBuat)
                                        .addGap(26, 26, 26)
                                        .addComponent(tombolUbah)
                                        .addGap(18, 18, 18)
                                        .addComponent(tombolHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(95, 95, 95))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Pembayaran)
                                        .addGap(97, 97, 97))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109)))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(kodeKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noTelpKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(AlamatKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolBuat)
                            .addComponent(tombolUbah)
                            .addComponent(tombolHapus))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pembayaran)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKasirActionPerformed

    private void kodeKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeKasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeKasirActionPerformed

    private void tombolBuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBuatActionPerformed
        if(kodeKasir.getText().equals("")||namaKasir.getText().equals("")||noTelpKasir.getText().equals("")||AlamatKasir.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Jangan ada data kosong !","Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sql = "insert into tb_kasir values(?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kodeKasir.getText());
            stat.setString(2, namaKasir.getText());
            stat.setString(3, noTelpKasir.getText());
            stat.setString(4, AlamatKasir.getText());

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
        String sql = "update tb_kasir set Nama_Kasir=?, No_Telp=?, Alamat=? where Kode_Kasir= "+kodeKasir.getText()+"";
        
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaKasir.getText());
            stat.setString(2, noTelpKasir.getText());
            stat.setString(3, AlamatKasir.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate");
            kosong();
            kodeKasir.requestFocus();
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
            String sql = "delete from tb_kasir where Kode_Kasir='"+kodeKasir.getText()+"'";
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

    private void tableMenuAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuAdminMouseClicked
        // TODO add your handling code here:
        kodeKasir.setText(tableMenuAdmin.getValueAt(tableMenuAdmin.getSelectedRow(), 0).toString());
        try {
            // TODO add your handling code here:
            int index = tableMenuAdmin.getSelectedRow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        namaKasir.setText(tableMenuAdmin.getValueAt(tableMenuAdmin.getSelectedRow(), 1).toString());           
        noTelpKasir.setText(tableMenuAdmin.getValueAt(tableMenuAdmin.getSelectedRow(), 2).toString());
        AlamatKasir.setText(tableMenuAdmin.getValueAt(tableMenuAdmin.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tableMenuAdminMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new AdminMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new EditMakanan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void PembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PembayaranActionPerformed
        // TODO add your handling code here:
        new Pembayaran().setVisible(true);
        dispose();
    }//GEN-LAST:event_PembayaranActionPerformed

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
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AlamatKasir;
    private javax.swing.JButton Pembayaran;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodeKasir;
    private javax.swing.JTextField namaKasir;
    private javax.swing.JTextField noTelpKasir;
    private javax.swing.JTable tableMenuAdmin;
    private javax.swing.JButton tombolBuat;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}

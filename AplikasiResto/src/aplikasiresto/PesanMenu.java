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
 * @author fajar
 */
public class PesanMenu extends javax.swing.JFrame {
    public static int statusSearching = 0;
    private final Connection conn=new koneksiDB().connect();
    private DefaultTableModel tabmode;
    private Object stat;
    public TableCellRenderer tengah = new Rendering_tengah();
    public TableCellRenderer kanan = new Rendering_kanan();
    /**
     * Creates new form MenuMakanan
     */
    public PesanMenu() {
        initComponents();
        aktif();
//        autonomor();
        datatabelMakanan();
        datatabelMinuman();
        datatabelPesan();
        lebarKolomMakanan();
        lebarKolomMinuman();
        lebarKolomPesan();
        perataanMakanan();
        perataanMinuman();
        perataanPesan();
    }
    
    protected void aktif(){ 
        jumlahMenu.setEnabled(true);
        hargaMenu.setEnabled(true);
    }
        
    public void kosong(){
        jumlahMenu.setText("");
        hargaMenu.setText("");
    }
    

    
    protected void datatabelMakanan(){
            Object[] baris = {"Nama Makanan","Harga"};
            tabmode = new DefaultTableModel(null, baris);
            tableMenuMakanan.setModel(tabmode);
            String sql = "select * from makanan";
            try{
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String namaMakanan = hasil.getString("Nama_Makanan");
                    String hargaMakanan = hasil.getString("Harga");

                    String[] data = {namaMakanan,hargaMakanan};
                    tabmode.addRow(data);
                } 
            }   catch (SQLException ex) {
                Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    protected void datatabelMinuman(){
            Object[] baris = {"Nama Minuman","Harga"};
            tabmode = new DefaultTableModel(null, baris);
            tableMenuMinuman.setModel(tabmode);
            String sql = "select * from minuman";
            try{
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String namaMinuman = hasil.getString("Nama_Minuman");
                    String hargaMinuman = hasil.getString("Harga");


                    String[] data = {namaMinuman,hargaMinuman};
                    tabmode.addRow(data);
                } 
            }   catch (SQLException ex) {
                Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    protected void datatabelPesan(){
            Object[] baris = {"Kode Pesan","Menu","Harga","Jumlah"};
            tabmode = new DefaultTableModel(null, baris);
            tablePesan.setModel(tabmode);
            String sql = "select * from pesanmenu";
            try{
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String kodePesan = hasil.getString("kodePesan");
                    String nama = hasil.getString("nama");
                    String harga = hasil.getString("harga");
                    String jumlah = hasil.getString("jumlah");


                    String[] data = {kodePesan,nama,harga,jumlah};
                    tabmode.addRow(data);
                } 
            }   catch (SQLException ex) {
                Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    public void lebarKolomMakanan(){ 
            TableColumn column;
            column = tableMenuMakanan.getColumnModel().getColumn(0); 
            column.setPreferredWidth(70);
            column = tableMenuMakanan.getColumnModel().getColumn(1); 
            column.setPreferredWidth(30);
        }
    public void lebarKolomMinuman(){ 
            TableColumn column;
            column = tableMenuMinuman.getColumnModel().getColumn(0); 
            column.setPreferredWidth(70);
            column = tableMenuMinuman.getColumnModel().getColumn(1); 
            column.setPreferredWidth(30);
            
        }
    public void lebarKolomPesan(){ 
            TableColumn column;
            column = tablePesan.getColumnModel().getColumn(0); 
            column.setPreferredWidth(30);
            column = tablePesan.getColumnModel().getColumn(0); 
            column.setPreferredWidth(30);
            column = tablePesan.getColumnModel().getColumn(1); 
            column.setPreferredWidth(70);
            column = tablePesan.getColumnModel().getColumn(2); 
            column.setPreferredWidth(60);
            
        }
    
    public void perataanMakanan(){
            tableMenuMakanan.getColumnModel().getColumn(0).setCellRenderer(tengah);
            tableMenuMakanan.getColumnModel().getColumn(1).setCellRenderer(tengah);

        }
        
    public void perataanMinuman(){
            tableMenuMinuman.getColumnModel().getColumn(0).setCellRenderer(tengah);
            tableMenuMinuman.getColumnModel().getColumn(1).setCellRenderer(tengah);

        }
    public void perataanPesan(){
            tablePesan.getColumnModel().getColumn(0).setCellRenderer(tengah);
            tablePesan.getColumnModel().getColumn(1).setCellRenderer(tengah);

        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        namaMenu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hargaMenu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePesan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMenuMinuman = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableMenuMakanan = new javax.swing.JTable();
        Buat = new javax.swing.JButton();
        Ubah = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jumlahMenu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kodePesan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nama Menu");

        namaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaMenuActionPerformed(evt);
            }
        });

        jLabel3.setText("Harga");

        hargaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaMenuActionPerformed(evt);
            }
        });

        tablePesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Pesan", " Menu", "Harga", "Jumlah"
            }
        ));
        tablePesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePesanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePesan);

        tableMenuMinuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Minuman", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jScrollPane3.setViewportView(tableMenuMinuman);

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableMenuMakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Makanan", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jScrollPane4.setViewportView(tableMenuMakanan);

        Buat.setText("Buat");
        Buat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuatActionPerformed(evt);
            }
        });

        Ubah.setText("Update");
        Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahActionPerformed(evt);
            }
        });

        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        jLabel1.setText("Jumlah");

        jButton5.setText("Pesan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jumlahMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahMenuActionPerformed(evt);
            }
        });

        jLabel4.setText("Kode Pesan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Buat))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hargaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Ubah)
                                .addGap(18, 18, 18)
                                .addComponent(Hapus))
                            .addComponent(jButton5)
                            .addComponent(jumlahMenu))
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(kodePesan))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(kodePesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hargaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jumlahMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Buat)
                                    .addComponent(Ubah)
                                    .addComponent(Hapus))
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePesanMouseClicked
    
    }//GEN-LAST:event_tablePesanMouseClicked

    private void tableMenuMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMinumanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMenuMinumanMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new MenuAwal().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMenuMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMakananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMenuMakananMouseClicked

    private void UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahActionPerformed
// TODO add your handling code here:
        String sql = "update pesanmenu set nama=?, harga=?, jumlah=? where kodePesan= "+kodePesan.getText()+"";
        
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaMenu.getText());
            stat.setString(2, hargaMenu.getText());
            stat.setString(3, jumlahMenu.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate");
            kosong();
            kodePesan.requestFocus();
            datatabelPesan();
            perataanPesan();
            lebarKolomPesan();
            //autonomor();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Diupdate" +e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_UbahActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuatActionPerformed
        if(kodePesan.getText().equals("")||namaMenu.getText().equals("")||hargaMenu.getText().equals("")||jumlahMenu.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Jangan ada data kosong !","Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sql = "insert into pesanmenu values(?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kodePesan.getText());
            stat.setString(2, namaMenu.getText());
            stat.setString(3, hargaMenu.getText());
            stat.setString(4, jumlahMenu.getText());


            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambah");

            datatabelPesan();
            perataanPesan();
            lebarKolomPesan();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" +e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_BuatActionPerformed

    private void namaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaMenuActionPerformed

    private void hargaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaMenuActionPerformed

    private void jumlahMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahMenuActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
int ok = JOptionPane.showConfirmDialog(null, "Apakah ada yakin ingin menghapus data", "Konfirmasi Dialog",
            JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "delete from pesanmenu where kodePesan='"+kodePesan.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");

                //jamJP.requestFocus();
                datatabelPesan();
                kosong();
                //autonomor();
                lebarKolomPesan();
                perataanPesan();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus" +e);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_HapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PesanMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buat;
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Ubah;
    private javax.swing.JTextField hargaMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jumlahMenu;
    private javax.swing.JTextField kodePesan;
    private javax.swing.JTextField namaMenu;
    private javax.swing.JTable tableMenuMakanan;
    private javax.swing.JTable tableMenuMinuman;
    private javax.swing.JTable tablePesan;
    // End of variables declaration//GEN-END:variables

 
}

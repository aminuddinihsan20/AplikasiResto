/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiresto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksiDB {
    static Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     private Connection koneksiDB;
     private String password = "";
        public Connection connect(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Berhasil koneksi");
            }catch(ClassNotFoundException ex){
                System.out.println("Gagal koneksi" +ex);
            }
            String url = "jdbc:mysql://localhost:3306/aplikasiresto";
            try{
                koneksiDB = DriverManager.getConnection(url, "root", "");
                System.out.println("Berhasil koneksi database");
            }catch(SQLException ex){
                System.out.println("Gagal koneksi database" +ex);
            }
        return koneksiDB;
        }
    
}

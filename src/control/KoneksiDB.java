package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author YODIEYS
 */
public class KoneksiDB {

    Connection conn;
    
    public Connection koneksiDB(){
        
        
        try{
            String url = "jdbc:mysql://localhost:3306/pulse";
            String user = "root";
            String pswd = "";
        
        
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(url,user,pswd);
            System.out.println("Berhasil Membuat Koneksi");
            
            return conn;
        } catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Gagal Membuat Koneksi !\n"+e,"ERROR",0);
            return null;
        }
        
        
    }
}

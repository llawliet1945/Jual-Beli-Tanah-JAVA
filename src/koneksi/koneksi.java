package koneksi;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author https://github.com/llawliet1945
 */
public class koneksi {
  private static Connection koneksi;
 public Connection getKoneksi(){
     if(koneksi == null){
         try{
             String url = new String();
              String username = new String();
              String password = new String();
              url = "jdbc:mysql://localhost:3306/apkpembukuan";
              username = "root";
              password= "";
              DriverManager.registerDriver(new com.mysql.jdbc.Driver());
              koneksi = (Connection) DriverManager.getConnection(url, username, password);
         }catch(Exception t){
               System.out.println("koneksi Error!"+t);
         }
     }
      return koneksi;
 }
}

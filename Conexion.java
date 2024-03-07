
package conf;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
    Connection con = null;
    
    public Conexion(){
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/pizza", "root", "");
        
    }catch (Exception e){
                System.err.println("No se pudo establecer la conexion");
        }
    }
    public Connection getConnection(){
        return con;
    }
}

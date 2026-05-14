package sistemaproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

  public class Conexion {
      
     
          
      private static final String URL =  "jdbc:mysql://localhost:3306/sistemaproductos?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
      
      private static final String USER = "root";
      private static final String PASSWORD = "";
      
      public static Connection getConexion() {
          Connection conn = null;
          
            try {
                
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("Conexion exitosa");
            
            
            } catch (ClassNotFoundException e) {
                System.out.println("Error driver: " + e.getMessage());
                
      
            } catch (SQLException e) {
                System.out.println("Error BD: " + e.getMessage()); 
                
            }
          
            return conn;
      
      }
 
  }

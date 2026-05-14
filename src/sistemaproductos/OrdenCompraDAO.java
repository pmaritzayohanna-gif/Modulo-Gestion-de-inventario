
package sistemaproductos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OrdenCompraDAO {
    
    // Metodo para insertar una orden de compra en la base de datos
    public void insertarOrden(OrdenCompraDO orden) {
        
        if (orden.getFecha() == null) {
            System.out.println("La fecha no puede ser null");
            return;
        }
        
        if (orden.getIdProveedor() <=0) {
            System.out.println("Proveedor inválido");
             return;
        }
             
        
               
            String sql = "INSERT INTO orden_compra (fecha_orden, id_proveedor, total) VALUES (?, ?, ?)";
            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)){
                
                if (conn == null) {
                System.out.println("Error conexion nula");
                return;
                  
           
                }
            
              // Enviar datos a la base de datos
            
            ps.setDate(1, new java.sql.Date(orden.getFecha().getTime())); 
            ps.setInt(2, orden.getIdProveedor());
            ps.setDouble(3, orden.getTotal());
            
            ps.executeUpdate();
            
            System.out.println("Orden insertada correctamente");
            
        }   catch (SQLException e) {
                    System.out.println("Error: al insertar orden: " + e.getMessage());
                    
                    
                
        }
    }
      
        public void listarOrdenes(){
            System.out.println("Entrando a listar ordenes...");
                    
            String sql = "SELECT  o.id_orden, o.fecha_orden, o.total, p.nombre "  +
                         "FROM orden_compra o "  +
                         "INNER JOIN proveedor  p ON o.id_proveedor = p.id_proveedor ";
                         
            
            
            try (Connection conn = Conexion.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 java.sql.ResultSet rs = ps.executeQuery()) {
                
                
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_orden"));
                System.out.println("Fecha: " + rs.getDate("fecha_orden"));
                System.out.println("Total: " + rs.getDouble("total"));
                System.out.println("Proveedor: " + rs.getString("nombre"));
                System.out.println("-------------------------");
                
            }
            
            } catch (SQLException e) {
                System.out.println("Error al listar: " + e.getMessage());
                
                
                
            }
        }
    
    
    
}

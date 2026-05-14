package sistemaproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ProductoDAO {
    
    
    private final String URL = "jdbc:mysql://localhost:3306/sistemaproductos";
    private final String USUARIO = "root";
    private final String PASSWORD = "";
    
    public Connection conectar() throws Exception {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    public void insertar (Producto p) throws Exception {
        String sql = "INSERT INTO producto (id, nombre, precio, stock) VALUES (?, ?, ?, ?)";
        
    
    Connection con = conectar();
    PreparedStatement ps = con.prepareStatement(sql);
    
    ps.setInt(1, p.getId());
    ps.setString(2, p.getNombre());
    ps.setDouble(3, p.getPrecio());
    ps.setInt(4, p.getStock());
    
    ps.executeUpdate();
    
    ps.close();
    con.close();
    
    }
    
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM producto WHERE id = ?";
        
        
    Connection con = conectar();
    PreparedStatement ps = con.prepareStatement(sql);
    
    ps.setInt(1, id);
    ps.executeUpdate();
    
    ps.close();
    con.close();
    }
    
    public void actualizar(Producto p) throws Exception {
        String sql = "UPDATE producto SET nombre = ?, precio = ?, stock = ? WHERE id = ?";
        
        Connection con = conectar();
        PreparedStatement ps = con.prepareStatement (sql);
        
        ps.setString(1, p.getNombre());
        ps.setDouble(2, p.getPrecio());
        ps.setInt(3, p.getStock());
        ps.setInt(4, p.getId());
        
        ps.executeUpdate();
        
        
        ps.close();
        con.close();
        
    }
}
        

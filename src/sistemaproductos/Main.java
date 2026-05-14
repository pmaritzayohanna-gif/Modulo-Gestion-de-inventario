
package sistemaproductos;

import java.util.Date;

public class Main {
    public static void main (String [] args) {
        
        System.out.println("Entrenando Al Main...");
        
        // Probar Conexion  
        
        Conexion.getConexion();
        
        System.out.println("Probando inserción de orden...");
        
     // Crear DAO 
        OrdenCompraDAO dao = new OrdenCompraDAO();
      
      // Crear Objeto Orden
        OrdenCompraDO orden = new OrdenCompraDO(0, new Date(), 1, 50000);
       
       // Insertar en la base de datos 
        dao.insertarOrden(orden);
        
        dao.listarOrdenes();
               
        System.out.println("FIN DEL PROGRAMA");
     
       
    }
}




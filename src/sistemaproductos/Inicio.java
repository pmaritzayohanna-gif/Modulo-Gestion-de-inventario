
package sistemaproductos;

import java.util.Date;

public class Inicio {
    
    public static void main (String[] args) {
        
        System.out.println("ENTRANDO AL MAIN");
        
        OrdenCompraDAO dao = new OrdenCompraDAO();
        OrdenCompraDO orden = new OrdenCompraDO(0, new Date(), 1, 50000);
        
        dao.insertarOrden(orden);
    }
}
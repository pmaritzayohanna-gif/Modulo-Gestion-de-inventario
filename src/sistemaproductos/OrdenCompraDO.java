
package sistemaproductos;

import java.util.Date;

public class OrdenCompraDO {
    
    private int idOrden;
    private Date fecha;
    private int idProveedor;
    private double total;
    
    public OrdenCompraDO(int idOrden, Date fecha, int idProveedor, double total) {
        
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.idProveedor = idProveedor;
        this.total = total;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }
    
    public double getTotal() {
        return total;
    }
    
    
}

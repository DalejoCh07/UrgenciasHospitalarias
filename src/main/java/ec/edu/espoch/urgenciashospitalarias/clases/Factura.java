
package ec.edu.espoch.urgenciashospitalarias.clases;

import ec.edu.espoch.urgenciashospitalarias.enumeraciones.MetodoPago;


public class Factura {
    //Atributos
    public int idFactura;
    public MetodoPago metodoPago;
    public double monto;
    public String ruc;
    public int idAtencion;
    
    //Constructor
    public Factura(MetodoPago metodoPago) {
        this.idFactura = idFactura++;
        this.metodoPago = metodoPago;
    }
    
    //Metodos
    public boolean generarFactura(Atencion atencion, Paciente paciente){
        
    }
    
}

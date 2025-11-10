
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
    public Factura(int idFactura, MetodoPago metodoPago) {
        this.idFactura = idFactura;
        this.metodoPago = metodoPago;
    }
    
    //Metodos
    public void generarFactura(Atencion atencion, Paciente paciente){
        this.monto=atencion.total;
        this.ruc=paciente.ruc;
        this.idAtencion=atencion.idAtencion;
    }
    
    public void imprimirFactura(){
        System.out.println("=======FACTURA========");
        System.out.println("ID Factura: "+this.idFactura);
        System.out.println("ID Atencion: "+this.idAtencion);
        System.out.println("Ruc Paciente: "+this.ruc);
        System.out.println("Metodo de pago: "+this.metodoPago);
        System.out.println("Monto: "+this.monto);
        System.out.println("=======================");
    }
    
    
}

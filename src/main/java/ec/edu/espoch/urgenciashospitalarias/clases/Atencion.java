
package ec.edu.espoch.urgenciashospitalarias.clases;

import ec.edu.espoch.urgenciashospitalarias.clases.Procedimiento;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.EstadoAtencion;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.TipoPrioridad;

public class Atencion {
    //Atributos
    public int idAtencion;
    public EstadoAtencion estadoAtencion;
    public Procedimiento[] procedimientos=new Procedimiento[3];
    public TipoPrioridad prioridad;
    public String motivoCancelacion;
    public double total;
    
    //Costructores
    public Atencion(EstadoAtencion estadoAtencion) {
        this.idAtencion = idAtencion++;
        this.estadoAtencion = estadoAtencion;
    }
    
    //Metodos
    public boolean asignarPrioridad(TipoPrioridad prioridad){
        boolean respuesta=false;
        if(this.estadoAtencion==EstadoAtencion.EN_TRIAJE){
            this.prioridad=prioridad;
            respuesta=true;
        }
        return respuesta;
    }
    
    public boolean cambiarEstado(EstadoAtencion nuevoEstado){
        boolean respuesta=false;
        if(nuevoEstado==EstadoAtencion.ALTA_EMITIDA){
           if(this.estadoAtencion==EstadoAtencion.LISTA_PARA_ALTA){
               this.estadoAtencion=nuevoEstado;
               respuesta=true;
           }
        } else{
            this.estadoAtencion=nuevoEstado;
            respuesta=true;
        }
        return respuesta;
    }
    
    public boolean agregarProcedimiento(Procedimiento procedimiento){
        boolean respuesta=false;
        for(int i=0;i<procedimientos.length;i++){
            //SI hay espacion añadir el item y retornar true
            //si no hay retornar false
            if (this.procedimientos[i]==null){ 
                this.procedimientos[i]=procedimiento;
                respuesta=true;
                break;
            }
        }
        return respuesta;
    }
    
    public boolean quitarProcedimiento(Procedimiento elimProcedimiento){
        // verifiar que existan espacios en el vector
        boolean respuesta=false;
        for(int i=0;i<procedimientos.length;i++){
            //SI hay espacion añadir el item y retornar true
            //si no hay retornar false
            if (procedimientos[i]==elimProcedimiento){
                procedimientos[i]=null;
                respuesta=true;
            }
        }
        return respuesta;
    }
    
    public boolean cancelarAtencion(String motivo){
        boolean respuesta=false;
        if(this.estadoAtencion==EstadoAtencion.REGISTRADA || this.estadoAtencion==EstadoAtencion.EN_TRIAJE){
            this.motivoCancelacion=motivo;
            respuesta=true;
        }
        return respuesta;
    }
    
    public double calcCovertura(double cobertura){
        double descuento=0;
        total=calcTotal();
        descuento=total*cobertura;
        return this.total=total-descuento;
    }
    
    public double calcTotal(){
        double total=0;
        for(int i=0;i<procedimientos.length;i++){
            total=total+this.procedimientos[i].costo;
        }
        return total;
    }
}
    


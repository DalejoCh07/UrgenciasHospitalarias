
package ec.edu.espoch.urgenciashospitalarias.clases;

import ec.edu.espoch.urgenciashospitalarias.clases.Procedimiento;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.EstadoAtencion;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.TipoPrioridad;

public class Atencion {
    //Atributos
    public int idAtencion;
    public EstadoAtencion estadoAtencion;
    public Procedimiento[] procedimientos=new Procedimiento[2];
    public TipoPrioridad prioridad;
    public String observacion;
    public String indicacion;
    public String medicacion;
    public String[] insumos= new String[2];
    public String motivoCancelacion;
    public double total;
    
    //Costructores
    public Atencion(int idAtencion, EstadoAtencion estadoAtencion) {
        this.idAtencion = idAtencion;
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
    
     public String agregarIndicacion(String indicacion){
        return this.indicacion=indicacion;
    }
    
    public String añadirObservacion(String observacion){ 
        return this.observacion=observacion;
    }
    
    public boolean cambiarEstado(EstadoAtencion nuevoEstado){
        boolean respuesta=false;
        if (this.estadoAtencion==EstadoAtencion.REGISTRADA && nuevoEstado==EstadoAtencion.EN_TRIAJE) {
            this.estadoAtencion=nuevoEstado;
            respuesta=true;
        } else if (this.estadoAtencion==EstadoAtencion.EN_TRIAJE && nuevoEstado==EstadoAtencion.EN_ATENCION) {
            this.estadoAtencion=nuevoEstado;
            respuesta=true;
        } else if (this.estadoAtencion==EstadoAtencion.EN_ATENCION && nuevoEstado==EstadoAtencion.LISTA_PARA_ALTA) {
            this.estadoAtencion=nuevoEstado;
            respuesta=true;
        } else if (this.estadoAtencion==EstadoAtencion.LISTA_PARA_ALTA && nuevoEstado==EstadoAtencion.ALTA_EMITIDA) {
            this.estadoAtencion=nuevoEstado;
            respuesta=true;
        } else{
            System.out.println("El cambio de estado debe seguir el orden REGISTADA-EN TRIAJE-EN ATENCION-LISTA PARA ALTA-ALTA EMITIDA.");
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
    
    public boolean agregarInsumo(String insumo){
        boolean respuesta=false;
        for(int i=0;i<insumos.length;i++){
            if (insumos[i]==null){
                this.insumos[i]=insumo;
                respuesta=true;
                if (this.insumos[i]==insumo){
                    this.insumos[i+1]="N/A";
                }
            }
        }
        return respuesta;
    }
    
    public boolean quitarInsumo(String elimInsumo){
        boolean respuesta=false;
        for(int i=0;i<insumos.length;i++){
            if(insumos[i]==elimInsumo){
                this.insumos[i]=null;
                respuesta=true;
            }
        }
        return respuesta;
    }
    
    public String ordenarMedicacion(String dosis){
        return this.medicacion=dosis;
    }
    
    public boolean cambiarMedicacion(String dosisNueva, EstadoAtencion estadoActual){
        boolean respuesta=false;
        if(estadoActual!=EstadoAtencion.EN_ATENCION){
            this.medicacion=dosisNueva;
            respuesta=true;
        }else{
            System.out.println("No se puede cambiar la dosis en estado 'En Atencion'");
        }
        return respuesta;
    }
    
    public boolean cancelarAtencion(String motivo){
        boolean respuesta=false;
        if(this.estadoAtencion==EstadoAtencion.REGISTRADA || this.estadoAtencion==EstadoAtencion.EN_TRIAJE){
            this.estadoAtencion=EstadoAtencion.CANCELADA;
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

    @Override
    public String toString() {
        return "Atencion{" + "idAtencion=" + idAtencion + ", estadoAtencion=" + estadoAtencion + ", procedimientos=" + procedimientos[1].tipoProcedimiento + ", prioridad=" + prioridad + ", observacion=" + observacion + ", indicacion=" + indicacion + ", medicacion=" + medicacion + ", insumos=" + insumos[1] + ", motivoCancelacion=" + motivoCancelacion + ", total=" + total + '}';
    }
    
   
}

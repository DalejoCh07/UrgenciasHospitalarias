
package ec.edu.espoch.urgenciashospitalarias.clases;


public class Procedimiento {
    //Atributos
    public String tipoProcedimiento;
    public int codigo;
    public String[] insumos= new String[3];
    public double costo;
    public String indicacion;
    public String resultados;
    
    //Contructor

    public Procedimiento(String tipoProcedimiento, int codigo) {
        this.tipoProcedimiento = tipoProcedimiento;
        this.codigo = codigo;
    }
    
    //Metodos
    public boolean agregarInsumo(String insumo){
        
    }
    public boolean quitarInsumo(String insumo){
        
    }
    public String agregarIndicacion(String indicacion){
        
    }
    public String ordenarMedicacion(String dosis){
        
    }
    public boolean cambiarMedicacion(String dosisNueva){
        
    }
    public boolean cancelarAtencion(String motivo){
        
    }
}


package ec.edu.espoch.urgenciashospitalarias.clases;


import ec.edu.espoch.urgenciashospitalarias.enumeraciones.TipoProcedimiento;


public class Procedimiento {
    //Atributos
    public TipoProcedimiento tipoProcedimiento;
    public int codigo;
    public double costo;
    public String resultados;
    
    //Contructor

    public Procedimiento(TipoProcedimiento tipoProcedimiento, int codigo) {
        this.tipoProcedimiento = tipoProcedimiento;
        this.codigo = codigo;
    }
   
    
}

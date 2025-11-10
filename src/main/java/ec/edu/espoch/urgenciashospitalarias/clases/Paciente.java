package ec.edu.espoch.urgenciashospitalarias.clases;


public class Paciente {
    //Atributos
    public int idPaciente;
    public String nombre;
    public String ruc;
    public double cobertura;
    public String dirección;
    
    //Constructor

    public Paciente(String nombre, String ruc, double cobertura, String dirección) {
        this.idPaciente= idPaciente++;
        this.nombre = nombre;
        this.ruc = ruc;
        this.cobertura = cobertura;
        this.dirección = dirección;
    }
    
}


package ec.edu.espoch.urgenciashospitalarias;

import ec.edu.espoch.urgenciashospitalarias.clases.Atencion;
import ec.edu.espoch.urgenciashospitalarias.clases.Factura;
import ec.edu.espoch.urgenciashospitalarias.clases.Paciente;
import ec.edu.espoch.urgenciashospitalarias.clases.Procedimiento;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.EstadoAtencion;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.MetodoPago;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.TipoPrioridad;
import ec.edu.espoch.urgenciashospitalarias.enumeraciones.TipoProcedimiento;


public class UrgenciasHospitalarias {

    public static void main(String[] args) {
       Atencion atencionUno=new Atencion(1, EstadoAtencion.REGISTRADA);
       Paciente pacienteUno=new Paciente("Paulo", "58963", 0.7, "Luis Guerra");
       atencionUno.cambiarEstado(EstadoAtencion.EN_TRIAJE);
       atencionUno.asignarPrioridad(TipoPrioridad.ROJO);
       atencionUno.añadirObservacion("Dolor irradiado, sudoración");
       atencionUno.cambiarEstado(EstadoAtencion.EN_ATENCION);
       
       Procedimiento procedimiento1AtencionUno=new Procedimiento(TipoProcedimiento.ECG, 01);
       procedimiento1AtencionUno.costo=30.0;
       atencionUno.agregarProcedimiento(procedimiento1AtencionUno);
       Procedimiento procedimiento2AtencionUno=new Procedimiento(TipoProcedimiento.LABORATORIO, 02);
       procedimiento2AtencionUno.costo=35.0;
       atencionUno.agregarProcedimiento(procedimiento2AtencionUno);
       
       atencionUno.agregarIndicacion("Alergia a penicilina");
       
       atencionUno.ordenarMedicacion("Paracetamol");
       
       atencionUno.agregarInsumo("Suero salino");
       
       
       atencionUno.cambiarEstado(EstadoAtencion.LISTA_PARA_ALTA);
       
       atencionUno.calcCovertura(pacienteUno.cobertura);
       
       atencionUno.cambiarEstado(EstadoAtencion.ALTA_EMITIDA);
        System.out.println(atencionUno.toString());
       
       Factura facturaUno=new Factura(1, MetodoPago.EFECTIVO);
       System.out.println("");
       facturaUno.generarFactura(atencionUno, pacienteUno);
       facturaUno.imprimirFactura();
       
       //2:05
       
       Atencion atencionDos=new Atencion(2, EstadoAtencion.REGISTRADA);
       Procedimiento procedimiento1AtencionDos=new Procedimiento(TipoProcedimiento.LABORATORIO, 28);
       atencionDos.agregarProcedimiento(procedimiento1AtencionDos);
       atencionDos.cancelarAtencion("Desistimiento de la familia");
       System.out.println(atencionDos.toString());
       
    }
}

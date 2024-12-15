/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Rafael Reyes
 */
public class Paciente extends Persona {
    private String historialMedico;
    
    public Paciente(){
        
    }
    
    public Paciente(int id, String nombre, String apellido, String direccion, String telefono, String historialMedico) {
        super(id, nombre, apellido, direccion, telefono); // Llama al constructor de la superclase
        this.historialMedico = historialMedico;

    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    
}

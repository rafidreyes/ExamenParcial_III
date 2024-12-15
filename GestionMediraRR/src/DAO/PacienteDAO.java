/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rafael Reyes
 */
public class PacienteDAO {
    private Connection conn;

    public PacienteDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void guardarPaciente(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO pacientes (nombre, apellido, direccion, telefono, historial_medico) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getDireccion());
            stmt.setString(4, paciente.getTelefono());
            stmt.setString(5, paciente.getHistorialMedico());
            stmt.executeUpdate();
        }
    }
    
    public List<Paciente> listarPacientes() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setHistorialMedico(rs.getString("historial_medico"));
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }
    
    public void modificarPaciente(Paciente paciente) throws SQLException {
        String sql = "UPDATE pacientes SET nombre=?, apellido=?, direccion=?, telefono=?, historial_medico=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getDireccion());
            stmt.setString(4, paciente.getTelefono());
            stmt.setString(5, paciente.getHistorialMedico());
            stmt.setInt(6, paciente.getId());
            stmt.executeUpdate();
        }
    }
    
    public void eliminarPaciente(int id) throws SQLException {
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Reyes
 */
public class MedicoDAO {
    private Connection conn;
    
    public MedicoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void guardarMedico(Medico medico) throws SQLException {
        String sql = "INSERT INTO medicos (nombre, apellido, direccion, telefono, especialidad) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getApellido());
            stmt.setString(3, medico.getDireccion());
            stmt.setString(4, medico.getTelefono());
            stmt.setString(5, medico.getEspecialidad());
            stmt.executeUpdate();
        }
    }
    
    public List<Medico> listarMedicos() throws SQLException {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medicos";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setDireccion(rs.getString("direccion"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medicos.add(medico);
            }
        }
        return medicos;
    }
    
    public void modificarMedico(Medico medico) throws SQLException {
        String sql = "UPDATE medicos SET nombre=?, apellido=?, direccion=?, telefono=?, especialidad=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getApellido());
            stmt.setString(3, medico.getDireccion());
            stmt.setString(4, medico.getTelefono());
            stmt.setString(5, medico.getEspecialidad());
            stmt.setInt(6, medico.getId()); // Importante: Establecer el ID para la cláusula WHERE
            stmt.executeUpdate();
        }
    }
    
    public void eliminarMedico(int id) throws SQLException {
        String sql = "DELETE FROM medicos WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
}

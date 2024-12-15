/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Rafael Reyes
 */
public class Conexion {
    Connection c;
    public Conexion(String gestionmedicarr) throws SQLException, ClassNotFoundException{
        
        try {
            /* Driver */
            String driver = "com.mysql.cj.jdbc.Driver";
            System.out.println( "=> Cargando el Driver:" );
            Class.forName( driver );
            System.out.println("Driver OK");
            
            /* Definiendo Base de Datos */
            String url = "jdbc:mysql://localhost:3306/"+ gestionmedicarr + "?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pass = "";
            
            /* Conectando */
            System.out.println( "=> conectando a la BD:" );
            c = DriverManager.getConnection( url , user , pass );
            System.out.println("Base de Datos OK");
        }
        catch( SQLException | ClassNotFoundException e ) {
            throw e;
        }  
    }
    
    public Connection getConexion(){
        return c;
    }
    
}

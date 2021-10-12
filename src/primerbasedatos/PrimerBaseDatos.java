/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerbasedatos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Soda
 */
public class PrimerBaseDatos {
     private String atributo;
      private String atributo2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //1-Crear conexion
        try {
            
            //pasamos por parametro ruta(url),usuario(por defecto es root) y contraseña(por defecto "")
            Connection miConexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "root");
        //2-Crear objeto Statement
        Statement miStatement=(Statement) miConexion.createStatement();
        
        //3-Ejecutar SQL
        
        ResultSet miResultset=miStatement.executeQuery("SELECT*FROM PRODUCTO");
        
        //4-Recorred ResultSet
            while (miResultset.next()) {  //mientras haya un registro ...              
                System.out.println(miResultset.getString("codigo")+" "+miResultset.getString("nombre")+" "); 
            }
        
        } catch (Exception e) {
            System.out.println("No conecta");
            e.printStackTrace();
        }
    }
    
}

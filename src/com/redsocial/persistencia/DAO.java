package com.redsocial.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected ResultSetMetaData resultadoMeta = null;
    protected Statement sentencia = null;
    private String user = "root";
    private String password = "Carmelita23";
    private String database = "mapuncu";

    protected void conectarBase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Error de Sistemas");
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error de Sistemas");
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            //Creo la conexión con la base
            conectarBase();
            //Creo la sentencia
            sentencia = conexion.createStatement();
            //Ejecuto la sentencia con el sql pasado como parámetro
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            try {
                //En caso de error retorno toda módificación para atras
                conexion.rollback();
            } catch (SQLException ex1) {
                throw new Exception("Error de Sistemas");
            }
            throw new Exception("Error de Sistemas");
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            //Creamos la conexión a la base
            conectarBase();
            //Creamos la sentencia
            sentencia = conexion.createStatement();
            //Ejecutamos la sentencia y obtenemos los resultados
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error de Sistemas");
        }
    }

    protected List stringColumnas() {

        List<String> list = new ArrayList();
        
        int numero;
        try {
            numero = resultadoMeta.getColumnCount();
            for (int i = 0; i < numero; i++) {
                list.add(resultadoMeta.getCatalogName(i));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}

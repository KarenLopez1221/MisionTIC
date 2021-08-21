package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {

    Connection conexion;

    public Requerimiento_1Dao() {
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Requerimiento_1>materialconstruccion() throws SQLException {
        ArrayList <Requerimiento_1> lista = new ArrayList<Requerimiento_1>();
        String sql = "Select ID_MaterialConstruccion, Nombre_Material, Precio_Unidad from MaterialConstruccion where Importado = 'Si'";
        Statement stmt  = conexion.createStatement();
        ResultSet resultado =  stmt.executeQuery(sql);
        while(resultado.next()){
            Requerimiento_1 materialcontruccion = new Requerimiento_1();
            materialcontruccion.setID_MaterialConstruccion(resultado.getInt(1));
            materialcontruccion.setNombre_Material(resultado.getString(2));
            materialcontruccion.setPrecio_Unidad(resultado.getInt(3));
            lista.add(materialcontruccion);
        }
        return lista;
    }
}
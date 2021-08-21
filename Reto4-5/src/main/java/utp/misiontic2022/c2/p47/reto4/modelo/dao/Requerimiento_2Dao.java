package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {

    Connection conexion;

    public Requerimiento_2Dao() {
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Requerimiento_2> promedio() throws SQLException {
        ArrayList <Requerimiento_2> lista = new ArrayList<Requerimiento_2>();
            String sql = "SELECT ID_MaterialConstruccion,Precio_Unidad FROM MaterialConstruccion where Importado = 'Si'";
            Statement stmt  = conexion.createStatement();
            ResultSet resultado2 =  stmt.executeQuery(sql);
            while(resultado2.next()){
                Requerimiento_2 promedio = new Requerimiento_2();
                promedio.setID_MaterialConstruccion(resultado2.getInt(1));
                promedio.setPrecio_Unidad(resultado2.getInt(2));
                lista.add(promedio);
            }
        return lista;
    }
}
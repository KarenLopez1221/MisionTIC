package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {

        Connection conexion;

        public Requerimiento_3Dao() {
            try {
                conexion = JDBCUtilities.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public ArrayList<Requerimiento_3>transformacion() throws SQLException {
            ArrayList <Requerimiento_3> lista = new ArrayList<Requerimiento_3>();
            String sql = "SELECT UPPER(SUBSTR(Nombre_Material,1,1)) || ' ' || LOWER(Importado) FROM MaterialConstruccion";
            Statement stmt  = conexion.createStatement();
            ResultSet resultado3 =  stmt.executeQuery(sql);
            while(resultado3.next()){
                Requerimiento_3 transformacion = new Requerimiento_3();
                transformacion.setImportado(resultado3.getString(1));
                lista.add(transformacion);
            }
            return lista;
        }
    }
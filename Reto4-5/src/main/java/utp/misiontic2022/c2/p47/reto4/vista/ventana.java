package utp.misiontic2022.c2.p47.reto4.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import utp.misiontic2022.c2.p47.reto4.modelo.dao.Requerimiento_1Dao;
import utp.misiontic2022.c2.p47.reto4.modelo.dao.Requerimiento_2Dao;
import utp.misiontic2022.c2.p47.reto4.modelo.dao.Requerimiento_3Dao;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;

//Clase para la GUI extiende de la clase de java JFrame
public class ventana extends JFrame implements ActionListener {

    private JButton b1, b2, b3;
    JTable miTabla1 =new JTable();
    JTable miTabla2 =new JTable();
    JTable miTabla3 =new JTable();
    JScrollPane mibarra1;
    JScrollPane mibarra2;
    JScrollPane mibarra3;

    public ventana() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        b1 = new JButton("Requerimiento1");
        b2 = new JButton("Requerimiento2");
        b3 = new JButton("Requerimiento3");
        c.add(b1);
        c.add(b2);
        c.add(b3);
        setSize(500,250);
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            JOptionPane.showMessageDialog(null,
                    "Conocer el id, el nombre del material y el precio por unidad de los materiales que si son importados");
            try {
                construirTabla(e);
                b1.hide();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            JOptionPane.showMessageDialog(null,
                    "Saber el promedio de los pesos por unidad de todos los materiales agrupados por si es importado o no");
            try {
                miTabla1.setModel(new DefaultTableModel());
                mibarra1.removeAll();
                construirTabla(e);
                b2.hide();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Transformar y obtener la primera letra del nombre del material en mayúscula concatenada con un espacio en blanco y luego concatenada con si es importado o no transformado a minúscula");
            try {
                miTabla2.setModel(new DefaultTableModel());
                mibarra2.removeAll();
                construirTabla(e);
                b3.hide();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void construirTabla(ActionEvent e) throws SQLException {

        mibarra1 = new JScrollPane();
        mibarra1.setBounds(27, 72, 400, 130);
        getContentPane().add(mibarra1);

        mibarra2 = new JScrollPane();
        mibarra2.setBounds(27, 72, 400, 130);
        getContentPane().add(mibarra2);

        mibarra3 = new JScrollPane();
        mibarra3.setBounds(27, 72, 400, 130);
        getContentPane().add(mibarra3);

        if (e.getSource() == b1) {
            String titulos[] = { "ID_MaterialConstruccion", "Nombre_Material", "Precio_Unidad" };
            String informacion[][] = obtenerMatriz(e);
            miTabla1 = new JTable(informacion, titulos);
            mibarra1.setViewportView(miTabla1);
        } else if (e.getSource() == b2) {
            String titulos[] = { "ID_MaterialConstruccion", "Precio_Unidad" };
            String informacion[][] = obtenerMatriz(e);
            miTabla2 = new JTable(informacion, titulos);
            mibarra2.setViewportView(miTabla2);
        } else {
            String titulos[] = { "Importado" };
            String informacion[][] = obtenerMatriz(e);
            miTabla3 = new JTable(informacion, titulos);
            mibarra3.setViewportView(miTabla3);
        }
    }

    private String[][] obtenerMatriz(ActionEvent e) throws SQLException {

        Requerimiento_1Dao req1 = new Requerimiento_1Dao();
        Requerimiento_2Dao req2 = new Requerimiento_2Dao();
        Requerimiento_3Dao req3 = new Requerimiento_3Dao();

        ArrayList<Requerimiento_1> lista = req1.materialconstruccion();
        ArrayList<Requerimiento_2> lista2 = req2.promedio();
        ArrayList<Requerimiento_3> lista3 = req3.transformacion();

        if (e.getSource() == b1) {
            String materiales[][] = new String[lista.size()][3];

            for (int i = 0; i < lista.size(); i++) {
                materiales[i][0] = lista.get(i).getID_MaterialConstruccion() + "";
                materiales[i][1] = lista.get(i).getNombre_Material() + "";
                materiales[i][2] = lista.get(i).getPrecio_Unidad() + "";
            }
            return materiales;

        } else if (e.getSource() == b2) {
            String promedio[][] = new String[lista2.size()][2];

            for (int i = 0; i < lista2.size(); i++) {
                promedio[i][0] = lista2.get(i).getID_MaterialConstruccion() + "";
                promedio[i][1] = lista2.get(i).getPrecio_Unidad() + "";
            }
            return promedio;
        } else {
            String transformacion[][] = new String[lista3.size()][1];

            for (int i = 0; i < lista3.size(); i++) {
                transformacion[i][0] = lista3.get(i).getImportado() + "";
            }
            return transformacion;
        }

    }
}

package utp.misiontic2022.c2.p47.reto4.vista;

import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.controlador.ControladorRequerimientos;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1(){
       
        try {
            System.out.println("Conocer el id, el nombre del material y el precio por unidad de los materiales que si son importados");
            ArrayList<Requerimiento_1> resultado = controlador.consultarRequerimiento1();
            System.out.println("ID_MaterialConstruccion Nombre_Material Precio_Unidad");
            for (Requerimiento_1 materialcontruccion:resultado){
                System.out.print(materialcontruccion.getID_MaterialConstruccion()+ " ");
                System.out.print(materialcontruccion.getNombre_Material()+ " ");
                System.out.println(materialcontruccion.getPrecio_Unidad());
            }
        } catch (Exception e) {
            System.err.println(e);
    }
}

    public static void requerimiento2(){
        try {
            System.out.println("Saber el promedio de los pesos por unidad de todos los materiales agrupados por si es importado o No");
            ArrayList<Requerimiento_2> resultado2 = controlador.consultarRequerimiento2();
            System.out.println("ID_MaterialConstruccion Precio_Unidad");
            for (Requerimiento_2 promedio:resultado2){
                System.out.print(promedio.getID_MaterialConstruccion()+ " ");
                System.out.println(promedio.getPrecio_Unidad());
            }
        } catch (Exception e) {
            System.err.println(e);
    }
}

    public static void requerimiento3(){
        try {
            System.out.println("Transformar y obtener la primera letra del nombre del material en mayúscula concatenada con un espacio en blanco y luego concatenada con si es importado o no transformado a minú scula");
            ArrayList<Requerimiento_3> resultado3 = controlador.consultarRequerimiento3();
            System.out.println("Importado");
            for (Requerimiento_3 transformacion:resultado3){
                System.out.println(transformacion.getImportado()+ " ");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}

package utp.misiontic2022.c2.p47.reto4;
import utp.misiontic2022.c2.p47.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p47.reto4.vista.VistaRequerimientos;
import utp.misiontic2022.c2.p47.reto4.vista.ventana;

/**
 * Esta clase solo se debe usar para hacer pruebas locales,
 * no se debe subir en iMaster
 */
public class App 
{
    public final ControladorRequerimientos controlador = new ControladorRequerimientos();
    public static void main( String[] args )
    
    {
        System.out.println("Requerimiento 1");
        VistaRequerimientos.requerimiento1();

        System.out.println("\nRequerimiento 2");
        VistaRequerimientos.requerimiento2();

        System.out.println("\nRequerimiento 3");
        VistaRequerimientos.requerimiento3();

        new ventana();

    }
    
}

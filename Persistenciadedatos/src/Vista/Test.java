
package Vista;

import Datos.*;
import Modelo.*;
import java.io.IOException;
import java.util.List;

public class Test {
    
     public static void main(String[] args) {
         
          VentanaPrincipal principal = new VentanaPrincipal();

//        Publicacion publiA = new Libro(13, 3, "123", "Soledad", "Gabriel", 2012, 100000);
//        Publicacion publiB = new AudioLibro(90, 50, "MP3", "132", "Llanto", "Jesus", 2014, 30000);
//        Publicacion publiC = new Libro(52, 1, "142", "MioCid", "Jesus", 2002, 200000);
//
//       // IAcessoDatos datos = new ArchivoTexto();
//          IAcessoDatos datos = new ArchivoObjeto();
//
//
//        try {
//            datos.registrarPublicacion(publiA);
//            datos.registrarPublicacion(publiB);
//            datos.registrarPublicacion(publiC);
//            
//           System.out.println("Todas las Publicaciones Registradas");
//            System.out.println("----------------------------------------");
//            List<Publicacion> Lista = datos.leerPublicacion();
//            imprimirLista(Lista);
//            
//            System.out.println("\nBusqueda Publicacion Por ISBN");
//            System.out.println("-----------------------------------");
//            String isbn="132";
//            Publicacion publi = datos.buscarPublicacion(isbn);
//            if(publi!=null){
//                System.out.println("Publicacion encontrada: ");
//                System.out.println(publi);
//            }
//            else{
//                System.out.println("La publicacion de isbn "+isbn+" no se encuentra registrado");
//            }
//            
//            System.out.println("\n Eliminar Publicacion por ISBN");
//            System.out.println("---------------------------------------");
//            String isbn2 = "142";
//            int eliminados = datos.eliminarPublicacion(isbn2);
//            System.out.println(eliminados + " registros eliminados");
//            
//            System.out.println("\nTodas las Publicaciones Registradas");
//            System.out.println("----------------------------------------");
//            Lista = datos.leerPublicacion();
//            imprimirLista(Lista);
//
//        } catch (IOException ioe) {
//            ioe.printStackTrace(System.out);
//        }
    }

    public static void imprimirLista(List<Publicacion> lista) {
        for (Publicacion publi : lista) {
            System.out.println(publi);
        }
        System.out.println("Total registradas: " + lista.size());
    }
    
    
}

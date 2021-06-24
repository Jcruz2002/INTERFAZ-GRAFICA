
package Datos;

import Modelo.*;
import java.io.IOException;
import java.util.List;

public interface IAcessoDatos {
    
    void registrarPublicacion(Publicacion publi) throws IOException;
    List<Publicacion> leerPublicacion()throws IOException;
    Publicacion buscarPublicacion(String isbn) throws IOException;
    int eliminarPublicacion(String isbn) throws IOException;
    void eliminarPubli(String isbn) throws IOException;
    List<Publicacion> consultaPubli(String texto) throws IOException;
}
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.*;
import Modelo.*;
import java.io.IOException;
import java.util.List;

public class GestiodePublicacion {
    
     private IAcessoDatos datos;
     
     public GestiodePublicacion(){
         
         this.datos = new ArchivoObjeto();
        //this.datos = new ArchivoTexto();
        //this.datos = new ListaMotocicleta();
         
         
     }
     
     public void registrarPublicacion(Publicacion publi) throws IOException {
        
        if(publi==null)
            throw new NullPointerException("Debe registrar una publicacion");
        
        if(publi.getIsbn()==null || publi.getIsbn().isEmpty())
            throw new NullPointerException("Debe registrar el isbn de la Publicacion");
        
        if(publi.getTitulo()==null || publi.getTitulo().isEmpty())
            throw new NullPointerException("Debe registrar el titulo de la publicacion");
        
        if(publi.getAn()<0)
            throw new NullPointerException("Debe registrar un año de la publicacion");
        
        if(publi.getCosto()<0)
            throw new NullPointerException("Debe registrar un valor en costo");
        
        if(this.buscarPublicacion(publi.getIsbn())!=null)
            throw new NullPointerException("La´publicacion ya se encuentra Registrada");
        
        this.datos.registrarPublicacion(publi);
    }

    public List<Publicacion> leerPublicacion() throws IOException {
        return this.datos.leerPublicacion();
    }

    public Publicacion buscarPublicacion(String isbn) throws IOException {
        if(isbn==null || isbn.isEmpty())
            throw new NullPointerException("Se reqiere un valor valido para la Isbn");
        
        return this.datos.buscarPublicacion(isbn);
    }
    
    public int eliminarPublicaciones(String isbn) throws IOException {
        return this.datos.eliminarPublicacion(isbn);
    }

    public List<Publicacion> consultarPublicacion(String isbn) throws IOException {
        return (List<Publicacion>) this.datos.buscarPublicacion(isbn);
    }

    public void eliminarPublicacion(String isbn) throws IOException {
        if(isbn==null || isbn.isEmpty())
            throw new NullPointerException("Se reqiere un valor valido para la Placa");
        
        this.datos.eliminarPubli(isbn);
    }
    
     public List<Publicacion> consultarPublicacionn(String texto) throws IOException {
        return this.datos.consultaPubli(texto);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author jdavi
 */
public class ListadePublicacion implements IAcessoDatos, Serializable {
    
    private List<Publicacion> lista;
    
    public ListadePublicacion()
    {
        this.lista = new ArrayList();
    }
    

    @Override
    public void registrarPublicacion(Publicacion publi) throws IOException {
        this.lista.add(publi);
    }

    @Override
    public List<Publicacion> leerPublicacion() throws IOException {
        return this.lista;
    }

    @Override
    public Publicacion buscarPublicacion(String isbn) throws IOException {
       for(Publicacion p: this.lista){
            if(p.getIsbn().equalsIgnoreCase(isbn)){
                return p;
            }
        }
        return null;
    }

    @Override
    public int eliminarPublicacion(String isbn) throws IOException {
        Iterator<Publicacion> i = this.lista.iterator();
        int contador=0;
        while(i.hasNext()){
            Publicacion p = (Publicacion)i.next();
            if(p.getIsbn().equals(isbn)){
                i.remove();
                contador ++;
            }
        }
        return contador;
    }
    
    @Override
    public void eliminarPubli(String isbn) throws IOException {
        Iterator<Publicacion> i = this.lista.iterator();
        int contador=0;
        while(i.hasNext()){
            Publicacion p = (Publicacion)i.next();
            if(p.getIsbn().equalsIgnoreCase(isbn)){
                i.remove();
            }
        }
    }

    @Override
    public List<Publicacion> consultaPubli(String texto) throws IOException {
        List<Publicacion> consulta= new ArrayList();
        for(Publicacion p: this.lista){
            if(p.getIsbn().toUpperCase().contains(texto.toUpperCase()) || p.getTitulo().toUpperCase().contains(texto.toUpperCase())){
                consulta.add(p);
            }
        }
        return consulta;
    }
    
}


package Modelo;

import java.io.Serializable;

public class Libro extends Publicacion {
    
    private int nPaginas, edicion;

    public Libro() {
    }

    public Libro(String isbn) {
        super(isbn);
    }

    public Libro(int nPaginas, int edicion, String isbn, String titulo, String autor, int an, double costo) {
        super(isbn, titulo, autor, an, costo);
        this.nPaginas = nPaginas;
        this.edicion = edicion;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    
    @Override
    public String getInfo() {
        return ",Num Pag="+ this.nPaginas +",Edicion="+ this.edicion;
    }
    
    @Override
    public String getEstru(){
        return nPaginas + ";" + edicion;   
    }
    
}

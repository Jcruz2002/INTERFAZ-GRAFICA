
package Modelo;

import java.io.Serializable;


public abstract class Publicacion implements Serializable {
    
    private String isbn,titulo,autor;
    private int an;
    private double costo;

    public Publicacion() {
    }

    public Publicacion(String isbn) {
        this.isbn = isbn;
    }

    public Publicacion(String isbn, String titulo, String autor, int an, double costo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.an = an;
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public abstract String getInfo();
    
    public abstract String getEstru();


    @Override
    public String toString() {
        return  "Pubicacion{"+"Isbn="+ isbn +",Titulo=" + titulo +",Autor=" + autor + ",Año=" + an + ",Costo=" + costo + this.getInfo()+"}";
    }

     public String getEstructuraTexto(){
       return  isbn + ";" + titulo + ";" + autor + ";" + an + ";" + costo + ";"+ this.getEstru();
    }

    
}

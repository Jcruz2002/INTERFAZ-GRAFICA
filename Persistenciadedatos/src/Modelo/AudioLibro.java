
package Modelo;

import java.io.Serializable;


public class AudioLibro extends Publicacion{
    
    private double duracion, peso;
    private String formato;

    public AudioLibro() {
    }

    public AudioLibro(String isbn) {
        super(isbn);
    }

    public AudioLibro(double duracion, double peso, String formato, String isbn, String titulo, String autor, int an, double costo) {
        super(isbn, titulo, autor, an, costo);
        this.duracion = duracion;
        this.peso = peso;
        this.formato = formato;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
     @Override
    public String getInfo() {
        return ",Duracion=" +this.duracion +",Peso=" +this.peso+ ",Formato=" +this.formato;
    }
    
    @Override
    public String getEstru(){
        return  duracion + ";" + peso + ";" + formato;   
    }

    
    
}

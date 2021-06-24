
package Datos;
import Modelo.*;
import java.io.*;
import java.util.*;

public class ArchivoTexto implements IAcessoDatos{
    
    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;
    
    public ArchivoTexto(String name) {
        this.archivo = new File(name);
    }

    public ArchivoTexto() {
        this("Lista.dat");
    }

    @Override
    public void registrarPublicacion(Publicacion publi) throws IOException {
        
         PrintWriter pw = null;
        try{
            this.aEscritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.aEscritura);
            pw.println(publi.getEstructuraTexto());
        
        }catch(IOException ioe){
            throw ioe;
        }
        finally{
            if(pw!=null)
                pw.close();
            if(this.aEscritura!=null)
                this.aEscritura.close();
        }  
    }
    
    
    private Publicacion crearPublicacion(String linea){
        String datos[] = linea.split(";");
        if(datos.length>7)
        {
        AudioLibro publi = new AudioLibro();
        publi.setIsbn(datos[0]);
        publi.setTitulo(datos[1]);
        publi.setAutor(datos[2]);
        publi.setAn(Integer.parseInt(datos[3]));
        publi.setCosto(Double.parseDouble(datos[4]));
        publi.setDuracion(Double.parseDouble(datos[5]));
        publi.setPeso(Double.parseDouble(datos[6]));
        publi.setFormato(datos[7]);
        return publi;
        }
        else
        {
        Libro publi = new Libro();
        publi.setIsbn(datos[0]);
        publi.setTitulo(datos[1]);
        publi.setAutor(datos[2]);
        publi.setAn(Integer.parseInt(datos[3]));
        publi.setCosto(Double.parseDouble(datos[4]));
        publi.setnPaginas(Integer.parseInt(datos[5]));
        publi.setEdicion(Integer.parseInt(datos[6]));
        return publi;
        }    
    }
    

    @Override
    public List<Publicacion> leerPublicacion() throws IOException {
        
        List<Publicacion> lista = new ArrayList();
        try{
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                String linea = this.aLectura.nextLine();
                Publicacion publi = this.crearPublicacion(linea);
                lista.add(publi);
            }
            return lista;
        }catch(IOException ioe){
            throw ioe;
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
    }

    @Override
    public Publicacion buscarPublicacion(String isbn) throws IOException {
        
          Publicacion encontrada = null;
           try{
                this.aLectura = new Scanner(this.archivo);
                while(this.aLectura.hasNext()){
                    String linea = this.aLectura.nextLine();
                    Publicacion publi = this.crearPublicacion(linea);
                    if(publi.getIsbn().equalsIgnoreCase(isbn)){
                        encontrada = publi;
                        break;
                    }
                }
                return encontrada;
           }
           catch(IOException ioe){
               throw ioe;
           }
           finally{
               if(this.aEscritura!=null)
                   this.aLectura.close();
           }
        
    }
    
    private void actualizarArchivo(File nvoArchivo) throws IOException{
         if(nvoArchivo.exists()){
             nvoArchivo.createNewFile();
         }
         
         if(this.archivo.delete()){
             if(!nvoArchivo.renameTo(this.archivo)){
                 throw new IOException("El Archivo temporal no fue renombrado");
             }
         }
         else
             throw new IOException("El Archivo original no fue eliminado");
        
    }
    
    
    

    @Override
    public int eliminarPublicacion(String isbn) throws IOException {
        
        int contador=0;
          
        try{
             this.aLectura = new Scanner(this.archivo);
             ArchivoTexto tmp = new ArchivoTexto("Temporal.dat");
             while(this.aLectura.hasNext()){
                 Publicacion publi= this.crearPublicacion(this.aLectura.nextLine());
                 if(publi.getIsbn().equals(isbn)){
                     contador++;
                 }
                 else{
                     tmp.registrarPublicacion(publi);
                 }
             }
             this.aLectura.close();
             this.actualizarArchivo(tmp.archivo);
             return contador;
        }
        catch(IOException ioe){
            throw ioe;
        }
        finally{
        }

        
    }

    @Override
    public List<Publicacion> consultaPubli(String texto) throws IOException {
        List<Publicacion> lista = new ArrayList();
           try{
                this.aLectura = new Scanner(this.archivo);
                while(this.aLectura.hasNext()){
                    String linea = this.aLectura.nextLine();
                    Publicacion p = this.crearPublicacion(linea);
                    if(p.getIsbn().toUpperCase().contains(texto.toUpperCase()) || p.getTitulo().toUpperCase().contains(texto.toUpperCase())){
                        lista.add(p);
                    }
                }
                return lista;
           }
           catch(IOException ioe){
               throw ioe;
           }
           finally{
               if(this.aEscritura!=null)
                   this.aLectura.close();
           }
    }

    @Override
    public void eliminarPubli(String isbn) throws IOException {
        
        int contador=0;
          
        try{
             this.aLectura = new Scanner(this.archivo);
             ArchivoTexto tmp = new ArchivoTexto("List.dat");
             while(this.aLectura.hasNext()){
                 Publicacion p= this.crearPublicacion(this.aLectura.nextLine());
                 if(!p.getIsbn().equalsIgnoreCase(isbn)){
                     tmp.crearPublicacion(isbn);
                 }
             }
             this.aLectura.close();
             this.actualizarArchivo(tmp.archivo);
        }
        catch(IOException ioe){
            throw ioe;
        }
        finally{
        }
    }

    
  
    
    
}


package Datos;

import Modelo.*;
import java.io.*;
import java.util.List;

public class ArchivoObjeto implements IAcessoDatos {
    
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public ArchivoObjeto(String name) {
        this.archivo = new File(name);
    }
    
    public ArchivoObjeto() {
        this("ListaObjetos.obj");
    }
    
     private void guardar(ListadePublicacion lista) throws IOException{
        
        this.oos=null;
        try{
            this.aEscritura = new FileOutputStream(this.archivo, false);
            this.oos = new ObjectOutputStream(this.aEscritura);
            this.oos.writeObject(lista);
        }catch(IOException ioe){
            throw ioe;
        }
        finally{
            if(this.oos!=null)
                this.oos.close();
            
            if(this.aEscritura!=null)
                this.aEscritura.close();
        }
    
    }
     
     private ListadePublicacion leer() throws IOException{
        
        ListadePublicacion lista = null;
        if(this.archivo.exists()){
            
            this.ois=null;
            try{
                this.aLectura = new FileInputStream(this.archivo);
                this.ois= new ObjectInputStream(this.aLectura);
                lista = (ListadePublicacion) this.ois.readObject();
                return lista;
            }catch(IOException ioe){
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase Lista Publicacion no existe");
            } 
            finally{
                if(this.ois!=null)
                    this.ois.close();
                
                if(this.aLectura!=null)
                    this.aLectura.close();
            }
        }
        else{
            lista = new ListadePublicacion();
            return lista;
        }
        
    }

    @Override
    public void registrarPublicacion(Publicacion publi) throws IOException {
        ListadePublicacion lista = this.leer();
        lista.registrarPublicacion(publi);
        this.guardar(lista);
    }

    @Override
    public List<Publicacion> leerPublicacion() throws IOException {
         ListadePublicacion lista = this.leer();
         return lista.leerPublicacion();
    }

    @Override
    public Publicacion buscarPublicacion(String isbn) throws IOException {
        ListadePublicacion lista = this.leer();
        return lista.buscarPublicacion(isbn);
    }

    @Override
    public int eliminarPublicacion(String isbn) throws IOException {
         ListadePublicacion lista = this.leer();
         int cont=lista.eliminarPublicacion(isbn);
         this.guardar(lista);
         return cont;
    }
    
    @Override
    public void eliminarPubli(String isbn) throws IOException {
         ListadePublicacion lista = this.leer();
         lista.eliminarPubli(isbn);
         this.guardar(lista);
    }
   

    @Override
    public List<Publicacion> consultaPubli(String texto) throws IOException {
        ListadePublicacion lista = this.leer();
        return lista.consultaPubli(texto);
    }
    
}

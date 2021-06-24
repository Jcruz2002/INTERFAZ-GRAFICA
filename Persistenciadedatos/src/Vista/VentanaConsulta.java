
package Vista;

import Modelo.*;
import Negocio.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaConsulta extends JDialog{
    
    private JPanel panelFiltro;
    private JScrollPane panelTabla;
    private Container contenedor;
    
    private JPanel panelBase;
    
    private JLabel lFiltro;
    private JTextField tFiltro;
    
    private JTable tabla;
    private DefaultTableModel modelo;
    private String titulos[]={"Isbn", "Titulo", "Autor", "Año", "Costo"};
    
    private GestiodePublicacion negocio;

    public VentanaConsulta(JFrame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("VENTANA.CONSULTA-PUBLICACION");
        this.negocio = new GestiodePublicacion();
        this.iniciarComponentes();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    
        
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelBase.setLayout(new BorderLayout());
        
        this.iniciarpanelFiltro();
        this.iniciarpanelTabla();
        
        try {

            List<Publicacion> lista = this.negocio.leerPublicacion();
            this.actualizarTabla(lista);
           

        } catch (IOException io) {
            io.printStackTrace();
        }
        this.contenedor.add(this.panelBase);
                
    }
    private void iniciarpanelFiltro() {
       
        this.panelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        this.lFiltro = new JLabel("Texto Filtro");
        this.tFiltro = new JTextField(10);
        this.tFiltro.addKeyListener(new eventoTeclado());
        
        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        
        this.panelBase.add(this.panelFiltro,BorderLayout.NORTH);
    }

    private void iniciarpanelTabla() {
        this.panelTabla = new JScrollPane();
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null,this.titulos);
        this.tabla.setModel(this.modelo);
        this.panelTabla.setViewportView(this.tabla);
        
        this.panelBase.add(this.panelTabla,BorderLayout.CENTER);
        
    }

    private void actualizarTabla(List<Publicacion> lista) {
        this.modelo.setNumRows(0);
        for(Publicacion p: lista){
            String fila[] = {p.getIsbn(),p.getTitulo(),p.getAutor(),""+p.getAn(),""+p.getCosto()};
            this.modelo.addRow(fila);  
        }
    }
    
    public void filtrarDatosTabla(){
        try {
            String texto = this.tFiltro.getText();
            List<Publicacion> listaFiltrada = this.negocio.consultarPublicacionn(texto);
            this.actualizarTabla(listaFiltrada);
        } catch (IOException ex) {
            this.mostrarMsg("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
     public void mostrarMsg(String titulo, String msg, int tipo){
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }
     
     class eventoTeclado extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent ke) {
            filtrarDatosTabla();
        }
    
    }
    
}

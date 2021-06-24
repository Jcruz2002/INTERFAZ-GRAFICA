
package Vista;

import Modelo.*;
import Negocio.GestiodePublicacion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;



public class VentanaRegistro extends JDialog{
    
    private JLabel lPublicacion,lIsbn,lTitulo,lAutor,lAnio,lCosto, lNpaginas, lEdicion,lDuracion,lPeso,lFormato;
    private JComboBox cPublicacion;
    private JTextField tIsbn, tTitulo, tAutor,tCosto,tNpaginas,tDuracion,tPeso;
    private JComboBox cAnio;
    private JRadioButton rEdicion1, rEdicion2, rEdicion3;
    private JRadioButton rFormato1, rFormato2, rFormato3;
    private ButtonGroup grupoRadio,grupoRadio2,grupoRadio3;
    
    private JButton bGuardar, bCancelar, bNuevo, bBuscar, bEliminar;
    private JPanel panelDatos, panelBotones;
    private Container contenedor;
    
    private GestiodePublicacion negocio;

    public VentanaRegistro(JFrame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("REGISTRO-PUBLICACIONES");
        this.negocio = new GestiodePublicacion();
        this.iniciarComponentes();
       // this.pack();
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.PanelDatos();
        this.PanelBotones();
    }
            
    public void PanelDatos(){
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(12, 2, 5,5));
        
        this.lPublicacion = new JLabel("  Publicacion: ");
        this.lIsbn = new JLabel("  Isb: ");
        this.lTitulo = new JLabel("  Titulo: ");
        this.lAutor = new JLabel("  Autor: ");
        this.lAnio = new JLabel("  Año: ");
        this.lCosto = new JLabel("  Costo: ");
        this.lNpaginas = new JLabel("  NPaginas: ");
        this.lEdicion = new JLabel("  Edicion: ");
        this.lDuracion = new JLabel(" Duracion: ");
        this.lPeso = new JLabel(" Peso: ");
        this.lFormato = new JLabel(" Formato: ");
        
        this.tIsbn = new JTextField(null);
        this.tIsbn.setEnabled(false);
        this.tTitulo = new JTextField(null);
        this.tAutor = new JTextField(null);
        this.tCosto = new JTextField(null);
        this.tNpaginas = new JTextField(null);
        this.tDuracion = new JTextField(null);
        this.tPeso = new JTextField(null);
        
        this.cPublicacion = new JComboBox();
        this.cPublicacion.setEnabled(false);
        this.cPublicacion.addItem("Libro");
        this.cPublicacion.addItem("AudioLibro");
        this.cPublicacion.addActionListener(new EventoClickComboPublicacion());
        
        this.cAnio = new JComboBox();
        this.cAnio.addItem("2000");
        this.cAnio.addItem("2011");
        this.cAnio.addItem("2013");
        this.cAnio.addItem("2014");
        this.cAnio.addItem("2015");
        this.cAnio.addItem("2016");
        this.cAnio.addItem("2018");
        this.cAnio.addItem("2020");
        
        this.rEdicion1 = new JRadioButton("1");
        this.rEdicion1.setSelected(true);
        this.rEdicion2 = new JRadioButton("2");
        this.rEdicion3 = new JRadioButton("3");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rEdicion1);
        this.grupoRadio.add(this.rEdicion2);
        this.grupoRadio.add(this.rEdicion3);
        JPanel panel = new JPanel();
        panel.add(this.rEdicion1);
        panel.add(this.rEdicion2);
        panel.add(this.rEdicion3);
        
        this.rFormato1 = new JRadioButton("MP3");
        this.rFormato1.setSelected(true);
        this.rFormato2 = new JRadioButton("MP4");
        this.rFormato3 = new JRadioButton("DVD");
        this.grupoRadio2 = new ButtonGroup();
        this.grupoRadio2.add(this.rEdicion1);
        this.grupoRadio2.add(this.rEdicion2);
        this.grupoRadio2.add(this.rEdicion3);
        JPanel panel2 = new JPanel();
        panel2.add(this.rFormato1);
        panel2.add(this.rFormato2);
        panel2.add(this.rFormato3);


              
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new EventoClickBotonGuardar());
        this.bGuardar.setEnabled(false);
        this.bCancelar = new JButton("Cancelar");
        this.bCancelar.setEnabled(false);
        
        this.panelDatos.add(this.lPublicacion);
        this.panelDatos.add(this.cPublicacion);
      
        this.panelDatos.add(this.lIsbn);
        this.panelDatos.add(this.tIsbn);
        
        this.panelDatos.add(this.lTitulo);
        this.panelDatos.add(this.tTitulo);
        
        this.panelDatos.add(this.lAutor);
        this.panelDatos.add(this.tAutor);
        
        this.panelDatos.add(this.lAnio);
        this.panelDatos.add(this.cAnio);
        
        this.panelDatos.add(this.lCosto);
        this.panelDatos.add(this.tCosto);
        
        this.panelDatos.add(this.lNpaginas);
        this.panelDatos.add(this.tNpaginas);
        
        this.panelDatos.add(this.lEdicion);
        this.panelDatos.add(panel);
        
        this.panelDatos.add(this.lDuracion);
        this.panelDatos.add(this.tDuracion);
        
        this.panelDatos.add(this.lPeso);
        this.panelDatos.add(this.tPeso);
        
        this.panelDatos.add(this.lFormato);
        this.panelDatos.add(panel2);
        
        
        this.panelDatos.add(this.bGuardar);
        this.panelDatos.add(this.bCancelar);
        
        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
        
        this.lDuracion.setVisible(false);
        this.tDuracion.setVisible(false);
        this.lPeso.setVisible(false);
        this.tPeso.setVisible(false);
        this.lFormato.setVisible(false);
        this.rFormato1.setVisible(false);
        this.rFormato2.setVisible(false);
        this.rFormato3.setVisible(false);

    }
    
    public void PanelBotones(){
        
        this.panelBotones = new JPanel();

        this.bNuevo = new JButton("Nuevo");
        this.bNuevo.addActionListener(new EventoClickBotonNuevo());
        this.bBuscar = new JButton("Buscar");
        this.bBuscar.addActionListener(new EventoClickBotonBuscar());
        this.bBuscar.setEnabled(false);
        this.bEliminar = new JButton("Eliminar");
        this.bEliminar.addActionListener(new EventoClickBotonEliminar());
        this.bEliminar.setEnabled(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(this.bNuevo);
        panel.add(this.bBuscar);
        panel.add(this.bEliminar);

        this.panelBotones.add(panel);

        this.contenedor.add(this.panelBotones, BorderLayout.EAST);
        
    }
    
     public void activarComponentes() {
        this.cPublicacion.setEnabled(true);
        this.tIsbn.setEnabled(true);
        this.bGuardar.setEnabled(true);
        this.bCancelar.setEnabled(true);
        this.bBuscar.setEnabled(true);
        this.bEliminar.setEnabled(true);
        this.cPublicacion.grabFocus();
    }
     
     public Publicacion leerDatos() {
        String publi = this.cPublicacion.getSelectedItem().toString();
       
            String isbn = this.tIsbn.getText();
            String titulo = this.tTitulo.getText();
            String autor = this.tAutor.getText();
            int an = Integer.parseInt(this.cAnio.getSelectedItem().toString());
            double costo = Double.parseDouble(this.tCosto.getText());
            
          if (publi.equalsIgnoreCase("Libro")) {
             int Np = Integer.parseInt(this.tNpaginas.getText());
             int ed;
             if (this.rEdicion1.isSelected()) {
                 ed = 1;
             } else if (this.rEdicion2.isSelected()) {
                 ed = 2;
             } else {
                 ed = 3;
             }
             Publicacion pu = new Libro(Np, ed, isbn, titulo, autor, an, costo);
             return pu;
         } else {

             double duracion = Double.parseDouble(this.tDuracion.getText());
             double peso = Double.parseDouble(this.tPeso.getText());
             String fr;
             if (this.rEdicion1.isSelected()) {
                 fr = "MP3";
             } else if (this.rEdicion2.isSelected()) {
                 fr = "MP4";
             } else {
                 fr = "DVD";
             }
             Publicacion pu2 = new AudioLibro(duracion, peso, fr, isbn, titulo, autor, an, costo);
             return pu2;
         }
    }
     
     public void eliminarPublicacion() {

        String isbn = this.tIsbn.getText();
        int confirmacion = JOptionPane.showConfirmDialog(this, "Desea eliminar el elemento", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
        if (confirmacion == 0) {
            try {
               this.negocio.eliminarPublicacion(isbn);
               this.mostrarMsg("Exito", "Elemento eliminado con exito", JOptionPane.INFORMATION_MESSAGE);
               this.limpiarComponentes();
            } catch (IOException | NullPointerException ex) {
                this.mostrarMsg("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }

    }
     
      public void mostrarPublicacion() {

        try {
            String isbn = this.tIsbn.getText();
            
            Publicacion publi = this.negocio.buscarPublicacion(isbn);

            if (publi == null) {
                throw new NullPointerException("La publicacion no se encuentra registrada");
            }

            this.tIsbn.setText(isbn);
            this.tTitulo.setText(publi.getTitulo());
            this.tAutor.setText(publi.getAutor());
            this.cAnio.setSelectedItem(publi.getAn());
            this.tCosto.setText(String.valueOf(publi.getCosto()));
          
        } catch (IOException | NullPointerException ex) {
            this.mostrarMsg("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarComponentes() {
        this.cPublicacion.setSelectedIndex(0);
        this.tIsbn.setText(null);
        this.tTitulo.setText(null);
        this.tAutor.setText(null);
        this.cAnio.setSelectedIndex(0);
        this.tCosto.setText(null);
        this.tNpaginas.setText(null);
        this.rEdicion1.setSelected(true);
        this.tDuracion.setText(null);
        this.tPeso.setText(null);
        this.rFormato1.setSelected(true);
    }

    public void mostrarMsg(String titulo, String msg, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    public void guardar() {

        try {
            Publicacion moto = this.leerDatos();
            this.negocio.registrarPublicacion(moto);
            this.mostrarMsg("Exito", "Registro almacenado cone xito", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarComponentes();
        } catch (IOException | NullPointerException ex) {
            //ex.printStackTrace();
            this.mostrarMsg("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }

    }
   
     public void ocultarComponentes() {
        String publi = this.cPublicacion.getSelectedItem().toString();
        if (publi.equalsIgnoreCase("Libro")) {
            this.lNpaginas.setVisible(true);
            this.tNpaginas.setVisible(true);
            this.lEdicion.setVisible(true);
            this.rEdicion1.setVisible(true);
            this.rEdicion2.setVisible(true);
            this.rEdicion3.setVisible(true);
            
            this.lDuracion.setVisible(false);
            this.tDuracion.setVisible(false);
            this.lPeso.setVisible(false);
            this.tPeso.setVisible(false);
            this.lFormato.setVisible(false);
            this.rFormato1.setVisible(false);
            this.rFormato2.setVisible(false);
            this.rFormato3.setVisible(false);
            
            
        } else {
           this.lNpaginas.setVisible(false);
           this.tNpaginas.setVisible(false);
           this.lEdicion.setVisible(false);
           this.rEdicion1.setVisible(false);
           this.rEdicion2.setVisible(false);
           this.rEdicion3.setVisible(false);
           
           this.lDuracion.setVisible(true);
           this.tDuracion.setVisible(true);
           this.lPeso.setVisible(true);
           this.tPeso.setVisible(true);
           this.lFormato.setVisible(true);
           this.rFormato1.setVisible(true);
           this.rFormato2.setVisible(true);
           this.rFormato3.setVisible(true);
        }
        
    }
     
      class EventoClickBotonNuevo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            activarComponentes();
        }
    }

    class EventoClickBotonGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            guardar();
        }
    }

    class EventoClickBotonBuscar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mostrarPublicacion();
        }
    }

    class EventoClickBotonEliminar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            eliminarPublicacion();
        }
    }
     
     class EventoClickComboPublicacion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            ocultarComponentes();
        }
    }
}

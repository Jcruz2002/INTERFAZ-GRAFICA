
package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;


public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem menuRegistro, mConsulta;
    private JPanel panelImg;
    private JLabel lImg;

    public VentanaPrincipal() {
        this("CREACION-DE-PUBLICACIONES");
    }
    
    public VentanaPrincipal(String string) {
        super(string);
        this.iniciarComponentes();
        
    }

    private void iniciarComponentes() {
        Image img = new ImageIcon("src/Imagenes/Icon.png").getImage();
        this.setIconImage(img);
        this.iniciarBarraMenu();
        this.crearPanelImg();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void iniciarBarraMenu(){
         
         this.barraMenu = new JMenuBar();
         
         this.menu = new JMenu("Operaciones");
         this.menu.setIcon(new ImageIcon("src/Imagenes/op.jpg"));
                  
         this.menuRegistro = new JMenuItem("Registro");
         this.menuRegistro.addActionListener(this);
         this.menuRegistro.setIcon(new ImageIcon("src/Imagenes/registr.jpg"));
         
         this.mConsulta = new JMenuItem("Consulta");
         this.mConsulta.addActionListener(this);
         this.mConsulta.setIcon(new ImageIcon("src/Imagenes/Base.jpg"));
         
         this.menu.add(this.menuRegistro);
         this.menu.add(this.mConsulta);
         
         this.barraMenu.add(this.menu);
         
         this.setJMenuBar(this.barraMenu);
     }
     
     public void crearPanelImg(){
         this.panelImg = new JPanel();
         this.panelImg.setLayout(new FlowLayout(FlowLayout.RIGHT));
         this.lImg = new JLabel();
         this.lImg.setIcon(new ImageIcon("src/Imagenes/UPC.jpg"));
         this.panelImg.add(this.lImg);
         
         this.getContentPane().setLayout(new BorderLayout());
         this.getContentPane().add(this.panelImg, BorderLayout.SOUTH);
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.menuRegistro) {
            VentanaRegistro registro = new VentanaRegistro(this, true);

        }

        if (ae.getSource() == this.mConsulta) {
            VentanaConsulta consulta = new VentanaConsulta(this, true);
        }
    }

    
        
    
    }

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class frameContabilidad extends javax.swing.JFrame {

   
    

    
    
//AQUI SE CREA EL FRAME CONTABILIDAD
     
    public frameContabilidad() throws SQLException {
        
         this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        //CAMBIAMOS EL ICONO
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.jpg")).getImage());
        //JUSTIFICAMOS A LA DERECHA LOS TEXTFIELD
        texBaseBen.setHorizontalAlignment(texBaseBen.RIGHT);
        ///LEEMOS BASE DE DATOS PARA INICIAR EN EL MISMO PERIODO EN QUE SE CERRÓ
              
         BDControl bd = null;
         String resultado="";
         resultado = bd.leePeriodo();
         
       //ESCRIBIMOS EN EL TITULO EL PERIODO CONTABLE
       
       String trim =resultado.substring(8);
       String anyo =resultado.substring(0,4);
       etiquetaResumen.setText("Resumen de Contabilidad del año: "+ anyo + " " + trim + "º"+" Trimestre.");
       
     
       //RELLENAMOS CASILLAS DE TEXTO CON LOS RESULTADOS LLAMANDO A LA CLASE RELLENACASILLAS
       RellenaCasillas rc = null;      
       String datos[]= rc.rellenaCamposConta();
      
       
        texBaseIng.setText(datos[0]);
        texIvaIng.setText(datos[1]);
        texTotalIng.setText(datos[2]);
        texBaseGas.setText(datos[3]);
        texIvaGas.setText(datos[4]);
        texTotalGas.setText(datos[5]);
        texBaseBen.setText(datos[6]);
        texIvaBen.setText(datos[7]);
        texTotalBen.setText(datos[8]);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaResumen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonFacRec = new javax.swing.JButton();
        botonFactEmi = new javax.swing.JButton();
        botonCuentas = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonProv = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        botonCambiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboAnyo = new javax.swing.JComboBox<>();
        comboTrimes = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        texBaseIng = new javax.swing.JTextField();
        texIvaIng = new javax.swing.JTextField();
        texTotalIng = new javax.swing.JTextField();
        texBaseGas = new javax.swing.JTextField();
        texIvaGas = new javax.swing.JTextField();
        texTotalGas = new javax.swing.JTextField();
        texBaseBen = new javax.swing.JTextField();
        texIvaBen = new javax.swing.JTextField();
        texTotalBen = new javax.swing.JTextField();
        botonInicio = new javax.swing.JButton();
        botonConfig = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuConfig = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaResumen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etiquetaResumen.setText("Resumen Contable");

        botonFacRec.setText("Facturas Recibidas");
        botonFacRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacRecActionPerformed(evt);
            }
        });

        botonFactEmi.setText("Facturas Emitidas");

        botonCuentas.setText("Cuentas ");

        botonClientes.setText("Clientes");

        botonProv.setText("Proveedores");

        botonCambiar.setText("Cambiar");
        botonCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cambiar periodo Contable");

        comboAnyo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", " " }));

        comboTrimes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trim. 1", "Trim. 2", "Trim. 3", "Trim. 4" }));

        jLabel2.setText("Total Ingresos");

        jLabel3.setText("Total gastos");

        jLabel4.setText("Total beneficios");

        jLabel5.setText("Base");

        jLabel6.setText("IVA");

        jLabel7.setText("Total");

        texBaseIng.setEditable(false);
        texBaseIng.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        texIvaIng.setEditable(false);
        texIvaIng.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texIvaIng.setText("jTextField2");

        texTotalIng.setEditable(false);
        texTotalIng.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texTotalIng.setText("jTextField3");

        texBaseGas.setEditable(false);
        texBaseGas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texBaseGas.setText("jTextField4");

        texIvaGas.setEditable(false);
        texIvaGas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texIvaGas.setText("jTextField5");

        texTotalGas.setEditable(false);
        texTotalGas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texTotalGas.setText("jTextField6");

        texBaseBen.setEditable(false);
        texBaseBen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texBaseBen.setText("jTextField7");

        texIvaBen.setEditable(false);
        texIvaBen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texIvaBen.setText("jTextField8");

        texTotalBen.setEditable(false);
        texTotalBen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texTotalBen.setText("jTextField9");

        botonInicio.setText("Inicio");
        botonInicio.setEnabled(false);

        botonConfig.setText("Configuración");

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        menuArchivo.setText("Archivo");

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuSalir);

        jMenuBar1.add(menuArchivo);

        menuEditar.setText("Editar");

        menuConfig.setText("Configuracion");
        menuEditar.add(menuConfig);

        jMenuBar1.add(menuEditar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(comboAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboTrimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(botonCambiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(etiquetaResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap(119, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texBaseIng)
                                    .addComponent(texBaseGas, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(texBaseBen)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(jLabel5)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel6))
                                    .addComponent(texIvaBen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(texTotalBen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texIvaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texIvaGas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel7))
                                    .addComponent(texTotalIng, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texTotalGas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(botonFacRec)
                                .addGap(18, 18, 18)
                                .addComponent(botonFactEmi)
                                .addGap(38, 38, 38)
                                .addComponent(botonCuentas)
                                .addGap(33, 33, 33)
                                .addComponent(botonClientes)
                                .addGap(37, 37, 37)
                                .addComponent(botonProv)
                                .addGap(33, 33, 33)
                                .addComponent(botonConfig)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonCerrar)
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(etiquetaResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFacRec)
                    .addComponent(botonFactEmi)
                    .addComponent(botonCuentas)
                    .addComponent(botonClientes)
                    .addComponent(botonProv)
                    .addComponent(botonInicio)
                    .addComponent(botonConfig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCambiar)
                        .addComponent(comboTrimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texBaseIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texIvaIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texTotalIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(texBaseGas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texBaseBen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texIvaBen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texTotalBen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texTotalGas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texIvaGas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(botonCerrar)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarActionPerformed
      //LEEMOS EL CONTENIDO SELECCIONADO DEL COMBO
        Object aO = comboAnyo.getSelectedItem();
        String anyo = String.valueOf(aO);
        
        int i = comboTrimes.getSelectedIndex();
        String trim = comboTrimes.getItemAt(i);
        
        i= i+1;
        String aGuardar = anyo + "trim" + i;
        
        //GUARDAMOS EN LA BASE DE DATOS
        BDControl bd = null;
        bd.guardaPeriodo(aGuardar);
        
        //ESCRIBIMOS EL TITULO
        etiquetaResumen.setText("Resumen de Contabilidad del año: "+ anyo + " " + i + "º"+" Trimestre.");
        
        //COMPROBAMOS SI EXISTE LA BASE DE DATOS DEL TRIMESTRE
        String factEmis = "factemi" + aGuardar;
        String factRecs = "factrec" + aGuardar;
        
        //SI NO EXISTE LO CREAMOS
        bd.creaTrimestre(factEmis, factRecs);
        
        //RELLENAMOS CASILLAS DE TEXTO CON LOS RESULTADOS LLAMANDO A LA CLASE RELLENACASILLAS
       RellenaCasillas rc = null;      
       String datos[];
        try {
            datos = rc.rellenaCamposConta();
            texBaseIng.setText(datos[0]);
            texIvaIng.setText(datos[1]);
            texTotalIng.setText(datos[2]);
            texBaseGas.setText(datos[3]);
            texIvaGas.setText(datos[4]);
            texTotalGas.setText(datos[5]);
            texBaseBen.setText(datos[6]);
            texIvaBen.setText(datos[7]);
            texTotalBen.setText(datos[8]);
            
        } catch (SQLException ex) {
            Logger.getLogger(frameContabilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
      
    }//GEN-LAST:event_botonCambiarActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonFacRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacRecActionPerformed
       //this.setVisible(false);
       this.dispose();
       
      
      
        try {
            
             frameFrasRecib ffr;
             ffr=new frameFrasRecib();
             ffr.setVisible(true);
            
        } catch (Exception ex) {
            Logger.getLogger(frameContabilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_botonFacRecActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
      
     
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frameContabilidad().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frameContabilidad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCambiar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonClientes;
    private javax.swing.JButton botonConfig;
    private javax.swing.JButton botonCuentas;
    private javax.swing.JButton botonFacRec;
    private javax.swing.JButton botonFactEmi;
    private javax.swing.JButton botonInicio;
    private javax.swing.JButton botonProv;
    private javax.swing.JComboBox<String> comboAnyo;
    private javax.swing.JComboBox<String> comboTrimes;
    private javax.swing.JLabel etiquetaResumen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuConfig;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTextField texBaseBen;
    private javax.swing.JTextField texBaseGas;
    private javax.swing.JTextField texBaseIng;
    private javax.swing.JTextField texIvaBen;
    private javax.swing.JTextField texIvaGas;
    private javax.swing.JTextField texIvaIng;
    private javax.swing.JTextField texTotalBen;
    private javax.swing.JTextField texTotalGas;
    private javax.swing.JTextField texTotalIng;
    // End of variables declaration//GEN-END:variables
}

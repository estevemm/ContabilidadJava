
package contabilidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


public class frameFrasRecib extends javax.swing.JFrame {

    
    @SuppressWarnings("empty-statement")
    public frameFrasRecib() throws SQLException {
        initComponents();
        //////////////////////////////////////////////
        
        //EJECUTA TODAS LAS TAREAS DE INICIO DE FRAME
        //CAMBIAMOS LOGO
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.jpg")).getImage());
        //DECLARAMOS VARIABLES
        BDControl bd = new BDControl();
        String periodo = bd.leePeriodo();
        String dato[] = new String[7];
        String nombre ="";
        int id=0;
        //TABLA DE FACTURAS RECIBIDAS
        //ESCRIBE TITULO
        String trim =periodo.substring(8);
        String anyo =periodo.substring(0,4);
        etiqTitulo.setText("FACTURAS RECIBIDAS " + trim + " trimestre del año " + anyo);
      
        //CREAR UN OBJETO MODELO
        DefaultTableModel model = new DefaultTableModel();
       
        //LLENAR CABECERA
        model.addColumn("Número factura");
        model.addColumn("Fecha factura");
        model.addColumn("Proveedor");
        model.addColumn("Base");
        model.addColumn("Iva");
        model.addColumn("Total");
        model.addColumn("Vencimiento");
        
         ResultSet datosBD = bd.leeFacturasRecibidas();
         ResultSet idP  ;
         //LLENAR CASILLAS DE TOTALES
         RellenaCasillas rc = new RellenaCasillas();
         String[] respuesta;
         respuesta =  rc.rellenaCamposConta();
         
         textTotBaseTrim.setText(respuesta[0]);
         textTotIvaTrim.setText(respuesta[1]);
         textTotalTrim.setText(respuesta[2]);
         
         //LLENAR TABLA CON DATOS LEIDOS DE LA BASE DE DATOS
         while(datosBD.next()){
             dato[0]=datosBD.getString("numFactura");
             dato[1]=datosBD.getString("fechaFactura");
             id = datosBD.getInt("id_proveedor");
             String sql = "SELECT nombre FROM proveedor WHERE id_proveedor = " + id;
            
             idP = bd.ejecutaSql(sql);
             idP.next();
             try{
                 nombre=idP.getString("nombre");
             }
             catch(Exception e){
                 nombre="**************";
             }
             
             dato[2]=nombre;
             dato[3]=datosBD.getString("base");
             dato[4]=datosBD.getString("iva");
             dato[5]=datosBD.getString("total");
             dato[6]=datosBD.getString("vto");
             model.addRow(dato);
             
         }
       
        tablaFR.setModel(model);
        //FIN LLENAR TABLA
        
          ///////////////////////////////////////////////////////////////////
         
    //LLENAR COMBO PROVEEDORES
        
        ResultSet proveedores = bd.leeProveedores();
        String proveedor;
        
        while(proveedores.next()){
            proveedor = proveedores.getString("nombre");
            comboNomProv.addItem(proveedor);
        }
        
    //LLENAR COMBO CONCEPTO
    ResultSet cuentas = bd.leeCuentas();
    
    while(cuentas.next()){
        comboConcep.addItem(cuentas.getString("concepto"));
    }
    
        
        
    }// FIN FRAMEFRASRECIBIDAS

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonCerrar = new javax.swing.JButton();
        botonContab = new javax.swing.JButton();
        botonFrasRec = new javax.swing.JButton();
        botonCuentas = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonProveed = new javax.swing.JButton();
        botonConfig = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFR = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textNif = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboConcep = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        textFechFra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textNumFra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textBase = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textTipo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textIva = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        comboNomProv = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        textTotBaseTrim = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textTotIvaTrim = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        textTotalTrim = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        textNumProv = new javax.swing.JTextField();
        etiqTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        botonContab.setText("Inicio");
        botonContab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContabActionPerformed(evt);
            }
        });

        botonFrasRec.setText("Facturas Recibidas");
        botonFrasRec.setEnabled(false);

        botonCuentas.setText("Cuentas");

        botonClientes.setText("Clientes");

        botonProveed.setText("Proveedores");

        botonConfig.setText("Configuración");

        tablaFR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaFR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaFR);

        jLabel2.setText("Nombre de Proveedor");

        jLabel3.setText("NIF");

        textNif.setEditable(false);

        jLabel4.setText("Num.Proveedor");

        jLabel5.setText("Concepto");

        comboConcep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona concepto" }));

        jLabel6.setText("Fecha Factura");

        jLabel7.setText("Num.Factura");

        jLabel8.setText("Base");

        jLabel9.setText("%");

        jLabel10.setText("IVA");

        jLabel11.setText("Total");

        comboNomProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige proveedor" }));
        comboNomProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNomProvActionPerformed(evt);
            }
        });

        jLabel12.setText("Total base trim.");

        textTotBaseTrim.setEditable(false);

        jLabel13.setText("Total Iva trim.");

        textTotIvaTrim.setEditable(false);

        jLabel14.setText("Total trim.");

        textTotalTrim.setEditable(false);

        botonGuardar.setText("Guardar");

        botonLimpiar.setText("Limpiar Formulario");

        textNumProv.setEditable(false);

        etiqTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiqTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqTitulo.setText("Facturas Recibidas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrada de facturas recibidas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(botonContab)
                                .addGap(33, 33, 33)
                                .addComponent(botonFrasRec)
                                .addGap(18, 18, 18)
                                .addComponent(botonCuentas)
                                .addGap(18, 18, 18)
                                .addComponent(botonClientes))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(comboConcep, 0, 217, Short.MAX_VALUE)
                                            .addComponent(comboNomProv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(textBase, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(textIva, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 11, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textTotBaseTrim, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(textTotIvaTrim)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(28, 28, 28)
                                        .addComponent(textNif, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textFechFra, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(39, 39, 39)
                                        .addComponent(textTotalTrim)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(botonCerrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(textNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(33, 33, 33)
                                        .addComponent(textNumFra, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonGuardar)
                        .addGap(46, 46, 46)
                        .addComponent(botonLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonProveed)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(botonConfig)))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(etiqTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonContab)
                    .addComponent(botonFrasRec)
                    .addComponent(botonCuentas)
                    .addComponent(botonClientes)
                    .addComponent(botonProveed)
                    .addComponent(botonConfig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(textNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboNomProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboConcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFechFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(textNumFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(textIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textTotBaseTrim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(textTotIvaTrim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(textTotalTrim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonLimpiar)
                    .addComponent(botonCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiqTitulo)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonContabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContabActionPerformed
        this.dispose();
        try { 
            frameContabilidad fc = new frameContabilidad();
            fc.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frameFrasRecib.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonContabActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
       System.exit(0);
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void comboNomProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNomProvActionPerformed
       BDControl bd = new BDControl();
       ResultSet rs;
       String nif = "*" , ids ="*";
       int id;
        String contenido = comboNomProv.getSelectedItem().toString();
        try{
            rs = bd.ejecutaSql("SELECT nif,id_proveedor FROM proveedor WHERE nombre='" + contenido + "'");
            while(rs.next()){
                nif = rs.getString("nif");
                id = rs.getInt("id_proveedor");
                ids = Integer.toString(id);
            }
        }
        catch(Exception e){
           nif = "********";
           
        }
       textNif.setText(nif);
       textNumProv.setText(ids);
    }//GEN-LAST:event_comboNomProvActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frameFrasRecib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameFrasRecib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameFrasRecib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameFrasRecib.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frameFrasRecib().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frameFrasRecib.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonClientes;
    private javax.swing.JButton botonConfig;
    private javax.swing.JButton botonContab;
    private javax.swing.JButton botonCuentas;
    private javax.swing.JButton botonFrasRec;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonProveed;
    private javax.swing.JComboBox<String> comboConcep;
    private javax.swing.JComboBox<String> comboNomProv;
    private javax.swing.JLabel etiqTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaFR;
    private javax.swing.JTextField textBase;
    private javax.swing.JTextField textFechFra;
    private javax.swing.JTextField textIva;
    private javax.swing.JTextField textNif;
    private javax.swing.JTextField textNumFra;
    private javax.swing.JTextField textNumProv;
    private javax.swing.JTextField textTipo;
    private javax.swing.JTextField textTotBaseTrim;
    private javax.swing.JTextField textTotIvaTrim;
    private javax.swing.JTextField textTotal;
    private javax.swing.JTextField textTotalTrim;
    // End of variables declaration//GEN-END:variables

    private String proveedores(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

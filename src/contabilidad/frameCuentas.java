/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Esteve
 */
public class frameCuentas extends javax.swing.JFrame {

    /**
     * Creates new form frameCuentas
     */
    public frameCuentas() throws SQLException {
        initComponents();
        
        botonCuentas.setEnabled(false);
          //TABLA DE cuentas
              
        //CREAR UN OBJETO MODELO
        DefaultTableModel model = new DefaultTableModel();
       
        //LLENAR CABECERA
        model.addColumn("Descripción");
        model.addColumn("Número de Cuenta");
         //LLENAR TABLA CON DATOS LEIDOS DE LA BASE DE DATOS
         BDControl bd = new BDControl();
         
         ResultSet datosBD = bd.leeCuentas();
         String dato[] = new String[2];
         while(datosBD.next()){
             dato[0]=datosBD.getString("concepto");
             dato[1]=datosBD.getString("id_cuenta");
             model.addRow(dato);
             
         }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        textDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textCuenta = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        botonContabilidad = new javax.swing.JButton();
        botonFrasRec = new javax.swing.JButton();
        botonFrasEmi = new javax.swing.JButton();
        botonCuentas = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonProveedores = new javax.swing.JButton();
        botonConfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Descripcion de la cuenta");

        jLabel3.setText("Número de cuenta");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CUENTAS CONTABLES");

        botonGuardar.setText("Guardar");

        botonLimpiar.setText("Limpiar Formulario");

        botonEditar.setText("Editar");

        botonBorrar.setText("Borrar");

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonCerrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botonEditar)
                            .addComponent(botonBorrar)
                            .addComponent(botonLimpiar)
                            .addComponent(botonGuardar))
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonLimpiar)
                        .addGap(37, 37, 37)
                        .addComponent(botonCerrar)))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        botonContabilidad.setText("Contabilidad");
        botonContabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContabilidadActionPerformed(evt);
            }
        });

        botonFrasRec.setText("Facturas Recibidas");
        botonFrasRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFrasRecActionPerformed(evt);
            }
        });

        botonFrasEmi.setText("Facturas Emitidas");
        botonFrasEmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFrasEmiActionPerformed(evt);
            }
        });

        botonCuentas.setText("Cuentas");

        botonClientes.setText("Clientes");

        botonProveedores.setText("Proveedores");

        botonConfig.setText("Configuración");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonContabilidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonFrasRec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonFrasEmi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonCuentas)
                                .addGap(18, 18, 18)
                                .addComponent(botonClientes)
                                .addGap(18, 18, 18)
                                .addComponent(botonProveedores)
                                .addGap(29, 29, 29)
                                .addComponent(botonConfig))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(textDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(textCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonContabilidad)
                    .addComponent(botonFrasRec)
                    .addComponent(botonFrasEmi)
                    .addComponent(botonCuentas)
                    .addComponent(botonClientes)
                    .addComponent(botonProveedores)
                    .addComponent(botonConfig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonContabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContabilidadActionPerformed
       this.dispose();
       
      
      
        try {
            
             frameContabilidad fc;
             fc=new frameContabilidad();
             fc.setVisible(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error", 1);
        }
    }//GEN-LAST:event_botonContabilidadActionPerformed

    private void botonFrasRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFrasRecActionPerformed
       this.dispose();
       
      
      
        try {
            
             frameFrasRecib ffr;
             ffr=new frameFrasRecib();
             ffr.setVisible(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error", 1);
        }
    }//GEN-LAST:event_botonFrasRecActionPerformed

    private void botonFrasEmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFrasEmiActionPerformed
        this.dispose();
       
      
      
        try {
            
             frameFrasEmitidas ffe;
             ffe=new frameFrasEmitidas();
             ffe.setVisible(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error", 1);
        }
    }//GEN-LAST:event_botonFrasEmiActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonClientes;
    private javax.swing.JButton botonConfig;
    private javax.swing.JButton botonContabilidad;
    private javax.swing.JButton botonCuentas;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonFrasEmi;
    private javax.swing.JButton botonFrasRec;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textCuenta;
    private javax.swing.JTextField textDescripcion;
    // End of variables declaration//GEN-END:variables
}
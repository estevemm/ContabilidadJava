
package contabilidad;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteve
 */
public class frameEditarFrasRec extends javax.swing.JFrame {

    
    public frameEditarFrasRec()   {
       
        initComponents();
       
        
      
       }//FIN FRAMEEDITARFRASREC
    
    public static void inicializaFrame(){
        
        textProv.setVisible(false);
        comboEditNumProv.setVisible(false);
        //comboCuentas.setVisible(false);
        textFecha.setVisible(false);
        String periodo = "";
       
       BDControl bd = new BDControl();
       try{
       periodo = bd.leePeriodo();
       
       
       ResultSet rsFacturas = bd.leeFacturasRecibidas();
       
       String numFra = textNumFra.getText();
      
      
       while(rsFacturas.next()){
           
              //RELLENA DATOS ECONOMICOS
               String cuenta = rsFacturas.getString("id_cuenta");
              
               
               textBase.setText(rsFacturas.getString("base"));
               textTipo.setText(rsFacturas.getString("tipo"));
               textIva.setText(rsFacturas.getString("iva"));
               textTotal.setText(rsFacturas.getString("total"));
             
       }  
       
                   //LLENAR COMBO CONCEPTO Y CUENTAS
                comboCuentas.setVisible(false);
               
                ResultSet cuentas = bd.leeCuentas();

                while(cuentas.next()){
                    comboConcepto.addItem(cuentas.getString("concepto"));
                    comboCuentas.addItem(cuentas.getString("id_cuenta"));
        
                }
                comboConcepto.setSelectedIndex(comboCuentas.getSelectedIndex());
                
                //LLENAR COMBO PROVEEDORES
        
                ResultSet proveedores = bd.leeProveedores();
                String proveedor, num_id;

                while(proveedores.next()){
                    proveedor = proveedores.getString("nombre");                   
                    num_id = proveedores.getString("id_proveedor");
                    //cuando encontramos el proveedor seleccionamos su nif
                     if(num_id.equals(textProv.getText())){
                        textNif.setText(proveedores.getString("nif"));                                                                       
                    }
                    comboProveedor.addItem(proveedor);           
                    comboEditNumProv.addItem(num_id);
                }
                
                comboEditNumProv.setSelectedItem(textProv.getText());
                comboProveedor.setSelectedIndex(comboEditNumProv.getSelectedIndex());
                textNumProv.setText(textProv.getText());
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e,"Ha ocurrido un error", 0);
       }
    }//FIN INICIALIZAFRAME
   
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNif = new javax.swing.JTextField();
        comboProveedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textNumProv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textNumFra = new javax.swing.JTextField();
        comboConcepto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboFecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textBase = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textTipo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textIva = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        textProv = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        comboEditNumProv = new javax.swing.JComboBox<>();
        comboCuentas = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        textVto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACTURA RECIBIDA EDITADA");

        jLabel2.setText("Nombre del proveedor");

        textNif.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        comboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Proveedor" }));

        jLabel3.setText("NIF");

        jLabel4.setText("Num.Proveed.");

        textNumProv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("Concepto");

        textNumFra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        comboConcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona concepto" }));

        jLabel6.setText("Fecha Factura");

        jLabel7.setText("Num.Fra.");

        jLabel8.setText("Base ");

        textBase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel9.setText("%");

        textTipo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTipo.setText("21");

        jLabel10.setText("IVA");

        textIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setText("Total");

        textTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        botonGuardar.setText("Guardar cambios");

        jButton1.setText("Borrar factura");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        textProv.setText("proveedor");

        textFecha.setText("fecha");

        comboEditNumProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "combo numero proveedor" }));

        comboCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar cuenta" }));

        jLabel12.setText("Vencimiento");

        textVto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboConcepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(65, 65, 65))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textBase, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel10)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textIva, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel11)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(108, 108, 108))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textNif, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(textNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel12)
                                        .addGap(43, 43, 43)
                                        .addComponent(textVto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(240, 240, 240)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textNumFra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(306, 306, 306))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboEditNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(textIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(textNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textNumFra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(comboFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textVto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEditNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(jButton1)
                    .addComponent(botonCancelar)
                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * @param args the command line arguments
      
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameEditarFrasRec().setVisible(true);
            }
        });
    }
   */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    static javax.swing.JComboBox<String> comboConcepto;
    public static javax.swing.JComboBox<String> comboCuentas;
    static javax.swing.JComboBox<String> comboEditNumProv;
    static com.toedter.calendar.JDateChooser comboFecha;
    static javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    static javax.swing.JTextField textBase;
    static javax.swing.JTextField textFecha;
    static javax.swing.JTextField textIva;
    static javax.swing.JTextField textNif;
    static javax.swing.JTextField textNumFra;
    static javax.swing.JTextField textNumProv;
    static javax.swing.JTextField textProv;
    static javax.swing.JTextField textTipo;
    static javax.swing.JTextField textTotal;
    public static javax.swing.JTextField textVto;
    // End of variables declaration//GEN-END:variables
}

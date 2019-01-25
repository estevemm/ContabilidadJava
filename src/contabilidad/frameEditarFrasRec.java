
package contabilidad;

import static contabilidad.frameFrasRecib.calculaFactura;
import static contabilidad.frameFrasRecib.fefr;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteve
 */
public class frameEditarFrasRec extends javax.swing.JFrame {
static String numFraIni, numProIni, fechIni;
    
    public frameEditarFrasRec()   {
       
        initComponents();
       //this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
      
       }//FIN FRAMEEDITARFRASREC
  /**
   * Este es el método que se inicia desde el frameFrasRec , con los valores asignados
   * desde allí.
   * Con los valores Numero de factura, numero de proveedor y fecha de factura busca la factura 
   * en concreto y asigna a cada casilla los valores que le corresponde
   * segun están en la base de datos.
   */  
    public static void inicializaFrame() {
       
        textProv.setVisible(false);
        comboEditNumProv.setVisible(false);
        comboCuentas.setVisible(false);
        textFecha.setVisible(false);
        String periodo = "";
        //asignamos el valor de los parametros iniciales para usarlos en modificacion de registro
       numFraIni = textNumFra.getText();
       numProIni = textProv.getText();
       fechIni = textFecha.getText();
       
       BDControl bd = new BDControl();
       try{
          
           //inicializa variables
       periodo = bd.leePeriodo();
       ResultSet rsFacturas = bd.leeFacturasRecibidas();    
       String numFra = textNumFra.getText();
           //LLENAR COMBO CONCEPTO Y CUENTAS
                
               
                ResultSet cuentas = bd.leeCuentas();

                while(cuentas.next()){
                    comboConcepto.addItem(cuentas.getString("concepto"));
                    comboCuentas.addItem(cuentas.getString("id_cuenta"));
        
                }
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
                //LLENAR DATOS CONCRETOS DE LA FACTURA
       while(rsFacturas.next()){
           String contenidoComboProv = rsFacturas.getString("id_proveedor");
          
           //CUANDO COINCIDEN NUM FRA, FECHA Y PROVEEDOR
           if(numFra.equals(rsFacturas.getString("numFactura")) && textFecha.getText().equals(rsFacturas.getString("fechaFactura")) && textProv.getText().equals(contenidoComboProv) ){
             
               //RELLENA DATOS Economicos
               textBase.setText(rsFacturas.getString("base"));
               textTipo.setText(rsFacturas.getString("tipo"));
               textIva.setText(rsFacturas.getString("iva"));
               textTotal.setText(rsFacturas.getString("total"));
               
               //PONE EL COMBO CONCEPTO EN EL ITEM CORRECTO
               String cuenta = rsFacturas.getString("id_cuenta");
               comboCuentas.setSelectedItem(cuenta);
               comboConcepto.setSelectedIndex(comboCuentas.getSelectedIndex());
               //LLENA VENCIMIENTO
               
               textVto.setText(rsFacturas.getString("vto"));
           } 
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
        botonBorrar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        textProv = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        comboEditNumProv = new javax.swing.JComboBox<>();
        comboCuentas = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        textVto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACTURA RECIBIDA EDITADA");

        jLabel2.setText("Nombre del proveedor");

        textNif.setEditable(false);
        textNif.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        comboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Proveedor" }));
        comboProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProveedorActionPerformed(evt);
            }
        });

        jLabel3.setText("NIF");

        jLabel4.setText("Num.Proveed.");

        textNumProv.setEditable(false);
        textNumProv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("Concepto");

        textNumFra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textNumFra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textNumFraPropertyChange(evt);
            }
        });
        textNumFra.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                textNumFraVetoableChange(evt);
            }
        });

        comboConcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona concepto" }));

        jLabel6.setText("Fecha Factura");

        jLabel7.setText("Num.Fra.");

        jLabel8.setText("Base ");

        textBase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textBase.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textBaseFocusLost(evt);
            }
        });
        textBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBaseActionPerformed(evt);
            }
        });

        jLabel9.setText("%");

        textTipo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTipo.setText("21");
        textTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textTipoFocusLost(evt);
            }
        });

        jLabel10.setText("IVA");

        textIva.setEditable(false);
        textIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setText("Total");

        textTotal.setEditable(false);
        textTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        botonGuardar.setText("Guardar cambios");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonBorrar.setText("Borrar factura");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        textProv.setText("proveedor");

        textFecha.setText("fecha");

        comboEditNumProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "combo numero proveedor" }));

        comboCuentas.setEditable(true);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33))))
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
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel12)
                                                .addGap(44, 44, 44)
                                                .addComponent(textVto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textNumFra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(30, 30, 30)
                                .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(comboEditNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textVto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEditNumProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonBorrar)
                    .addComponent(botonCancelar)
                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(368, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
         //Reabrimos el frameFrasRecib
           frameFrasRecib ffr;
        try {
            ffr = new frameFrasRecib();
            ffr.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frameEditarFrasRec.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      
        
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
         borraFactura();
         this.setVisible(false);
            //Reabrimos el frameFrasRecib
           frameFrasRecib ffr;
      
        try {
            ffr = new frameFrasRecib();
             ffr.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frameEditarFrasRec.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void textBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBaseActionPerformed

    private void textBaseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textBaseFocusLost
        
        String texCont = textBase.getText();
       String texTip = textTipo.getText();
       try{
           float b = Float.valueOf(texCont.trim()).floatValue();
           float i = Float.valueOf(texTip.trim()).floatValue();
           float[] resultados = calculaFactura(b,i);
           textIva.setText(Float.toString(resultados[0]));
           textTotal.setText(Float.toString(resultados[1]));
           
           
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Los valores decimales se separan con un punto ","Debes introducir un  valor numérico",2);
           textBase.setText("");
       }
    }//GEN-LAST:event_textBaseFocusLost

    private void textTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textTipoFocusLost
         
        String texCont = textBase.getText();
       String texTip = textTipo.getText();
       try{
           float b = Float.valueOf(texCont.trim()).floatValue();
           float i = Float.valueOf(texTip.trim()).floatValue();
           float[] resultados = calculaFactura(b,i);
           textIva.setText(Float.toString(resultados[0]));
           textTotal.setText(Float.toString(resultados[1]));
           
           
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Los valores decimales se separan con un punto ","Debes introducir un  valor numérico",2);
           textBase.setText("");
       }
    }//GEN-LAST:event_textTipoFocusLost

    private void comboProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProveedorActionPerformed
       
        BDControl bd = new BDControl();
       ResultSet rs;
       String nif = "*" , ids ="*";
       int id;
        String contenido = comboProveedor.getSelectedItem().toString();
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
    }//GEN-LAST:event_comboProveedorActionPerformed

    private void textNumFraPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textNumFraPropertyChange
       
    }//GEN-LAST:event_textNumFraPropertyChange

    private void textNumFraVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_textNumFraVetoableChange
      
    }//GEN-LAST:event_textNumFraVetoableChange

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
       borraFactura();
       int id_proveedor = Integer.parseInt(textNumProv.getText());
       
       ///////////////////////////////////////
       int anno = comboFecha.getCalendar().get(Calendar.YEAR);
       String ano =Integer.toString(anno);
                int mes =comboFecha.getCalendar().get(Calendar.MARCH);
                mes++;
            int trimIn =0;
                if(mes==1 || mes==2 || mes==3)trimIn=1;
                if(mes==4 || mes==5 || mes==6)trimIn=2;
                if(mes==7 || mes==8 || mes==9)trimIn=3;
                if(mes==10 || mes==11 || mes==12)trimIn=4;
                String mess = String.format("%02d",mes);
                
                String dia = String.format("%02d",comboFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
       String fechaOrden = ano+mess+dia;
       String fechaFactura   = dia+"/"+mess+"/"+ano ;
       //Valida periodo
      try{
       
            BDControl bd = new BDControl();
           String periodo = bd.leePeriodo();
              String t =periodo.substring(8);
              String a =periodo.substring(0,4);
              int trim = Integer.parseInt(t);
              int anyo = Integer.parseInt(a);

            if(trimIn == trim && anno == anyo){
                 
                /////////////////////////////////////        
                String numFra   = textNumFra.getText();
                String id_cuenta = comboCuentas.getSelectedItem().toString();
                float base   = Float.parseFloat(textBase.getText());
                float tipo  = Float.parseFloat(textTipo.getText());
                float iva  = Float.parseFloat(textIva.getText());
                float total = Float.parseFloat(textTotal.getText());
                String vto = textVto.getText();

                   
                         bd.guardaFactRecib(id_proveedor, fechaFactura, fechaOrden, numFra, id_cuenta, base, tipo, iva, total, vto );

                       this.setVisible(false);
                          //Reabrimos el frameFrasRecib
                            frameFrasRecib ffr;

                             ffr = new frameFrasRecib();
                             ffr.setVisible(true);

            }else{
                JOptionPane.showMessageDialog(null,"Esta fecha no corresponde al período en el que estamos trabajando", "Atención",0);    
            }
      }
      catch(Exception e) {
          JOptionPane.showMessageDialog(null,e , "Ha ocurrido un error",0);
      }     
        
       
    }//GEN-LAST:event_botonGuardarActionPerformed
   
  
    
    private static void borraFactura(){
      
        
        BDControl bd = new BDControl();
      
       
        try {
            String periodo = bd.leePeriodo();
            String sql = "DELETE FROM factrec" + periodo + " WHERE id_proveedor = '" + numProIni + "' AND fechaFactura = '" ;
            sql = sql + fechIni + "' AND numFactura = '" + numFraIni + "'";
            
            bd.ejecutaUpdate(sql);
           
       
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex, "Ha ocurrido un error", 0);
        }
        
        
    }
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
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    static javax.swing.JComboBox<String> comboConcepto;
    public static javax.swing.JComboBox<String> comboCuentas;
    static javax.swing.JComboBox<String> comboEditNumProv;
    static com.toedter.calendar.JDateChooser comboFecha;
    static javax.swing.JComboBox<String> comboProveedor;
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

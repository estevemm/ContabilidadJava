
package contabilidad;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frameFrasRecib extends javax.swing.JFrame {

    
    @SuppressWarnings("empty-statement")
    public frameFrasRecib() throws SQLException {
        //PANTALLA COMPLETA 
        this.setExtendedState(MAXIMIZED_BOTH);
        
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
        String proveedor, num_id;
        
        while(proveedores.next()){
            proveedor = proveedores.getString("nombre");
            num_id = proveedores.getString("id_proveedor");
            comboNomProv.addItem(proveedor);
            comboEditarProv.addItem(proveedor);
            comboEditNumProv.addItem(num_id);
        }
        
    //LLENAR COMBO CONCEPTO Y CUENTAS
    comboCuentas.setVisible(false);
    comboEditNumProv.setVisible(false);
    ResultSet cuentas = bd.leeCuentas();
    
    while(cuentas.next()){
        comboConcep.addItem(cuentas.getString("concepto"));
        comboCuentas.addItem(cuentas.getString("id_cuenta"));
        
    }
    //LLENAR DATOS DE TOTALES TRIMESTRE
           
       String datos[]= rc.rellenaCamposConta();
      
       
        
        textTotBaseTrim.setText(datos[3]);
        textTotIvaTrim.setText(datos[4]);
        textTotalTrim.setText(datos[5]);
        
        
    }// FIN FRAMEFRASRECIBIDAS
    
    

    public static float[] calculaFactura(float base, float tipo){
        float iva = base*tipo/100;
        float total = base + iva;
        float[] resultados = {iva, total};
        
        
        
       return resultados; 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        botonCerrar = new javax.swing.JButton();
        botonContab = new javax.swing.JButton();
        botonFrasRec = new javax.swing.JButton();
        botonCuentas = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonProveed = new javax.swing.JButton();
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
        jCalendarCombo1 = new org.freixas.jcalendar.JCalendarCombo();
        botonFactEmi = new javax.swing.JButton();
        botonConfig = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboCuentas = new javax.swing.JComboBox<>();
        textVto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        botonEditarFra = new javax.swing.JButton();
        comboEditarProv = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        textEditNumFra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        calendarEditFra = new org.freixas.jcalendar.JCalendarCombo();
        comboEditNumProv = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 730, -1, -1));

        botonContab.setText("Inicio");
        botonContab.setAlignmentX(10.0F);
        botonContab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContabActionPerformed(evt);
            }
        });
        getContentPane().add(botonContab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        botonFrasRec.setText("Facturas Recibidas");
        botonFrasRec.setEnabled(false);
        getContentPane().add(botonFrasRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        botonCuentas.setText("Cuentas");
        getContentPane().add(botonCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        botonClientes.setText("Clientes");
        getContentPane().add(botonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        botonProveed.setText("Proveedores");
        getContentPane().add(botonProveed, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 29, 1132, 0));

        tablaFR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaFR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaFR);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 1190, 309));

        jLabel2.setText("Nombre de Proveedor");
        jLabel2.setAlignmentX(100.0F);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, -1, -1));

        jLabel3.setText("NIF");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, 20));

        textNif.setEditable(false);
        getContentPane().add(textNif, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 92, -1));

        jLabel4.setText("Num.Proveedor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, 20));

        jLabel5.setText("Concepto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        comboConcep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona concepto" }));
        comboConcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConcepActionPerformed(evt);
            }
        });
        getContentPane().add(comboConcep, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 260, -1));

        jLabel6.setText("Fecha Factura");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        jLabel7.setText("Num.Factura");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, -1, -1));
        getContentPane().add(textNumFra, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 96, -1));

        jLabel8.setText("Base");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 225, -1, -1));

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
        getContentPane().add(textBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 110, -1));

        jLabel9.setText("%");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 225, -1, -1));

        textTipo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTipo.setText("21");
        textTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textTipoFocusLost(evt);
            }
        });
        getContentPane().add(textTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 40, -1));

        jLabel10.setText("IVA");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 225, -1, -1));

        textIva.setEditable(false);
        textIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(textIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 92, -1));

        jLabel11.setText("Total");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 225, -1, -1));

        textTotal.setEditable(false);
        textTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(textTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 88, -1));

        comboNomProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige proveedor" }));
        comboNomProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNomProvActionPerformed(evt);
            }
        });
        getContentPane().add(comboNomProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 280, -1));

        jLabel12.setText("Total base trim.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 730, -1, -1));

        textTotBaseTrim.setEditable(false);
        getContentPane().add(textTotBaseTrim, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 730, 76, -1));

        jLabel13.setText("Total Iva trim.");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 730, -1, -1));

        textTotIvaTrim.setEditable(false);
        getContentPane().add(textTotIvaTrim, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 730, 73, -1));

        jLabel14.setText("Total trim.");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 730, -1, -1));

        textTotalTrim.setEditable(false);
        getContentPane().add(textTotalTrim, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 730, 77, -1));

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 306, -1, -1));

        botonLimpiar.setText("Limpiar Formulario");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(botonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 306, -1, -1));

        textNumProv.setEditable(false);
        getContentPane().add(textNumProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 96, -1));

        etiqTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiqTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqTitulo.setText("Facturas Recibidas");
        getContentPane().add(etiqTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 1015, -1));
        getContentPane().add(jCalendarCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 190, -1));

        botonFactEmi.setText("Facturas Emitidas");
        getContentPane().add(botonFactEmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        botonConfig.setText("Configuración");
        getContentPane().add(botonConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        jLabel1.setText("Vencimiento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, 20));

        comboCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "numero de cuenta" }));
        getContentPane().add(comboCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 170, -1, -1));
        getContentPane().add(textVto, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 220, 130, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonEditarFra.setText("Editar factura");
        botonEditarFra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarFraActionPerformed(evt);
            }
        });
        jPanel1.add(botonEditarFra);

        comboEditarProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige proveedor" }));
        comboEditarProv.setPreferredSize(new java.awt.Dimension(200, 26));
        comboEditarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEditarProvActionPerformed(evt);
            }
        });
        jPanel1.add(comboEditarProv);

        jLabel15.setText("Num.Fra.");
        jPanel1.add(jLabel15);

        textEditNumFra.setPreferredSize(new java.awt.Dimension(100, 28));
        textEditNumFra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEditNumFraActionPerformed(evt);
            }
        });
        jPanel1.add(textEditNumFra);

        jLabel16.setText("Fecha Fra.");
        jPanel1.add(jLabel16);
        jPanel1.add(calendarEditFra);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 880, -1));

        comboEditNumProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de proveedor editado" }));
        getContentPane().add(comboEditNumProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 220, -1, -1));

        setBounds(0, 0, 1243, 814);
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

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
    //REINICIA TODOS LOS CAMPOS DE TEXTO
     textBase.setText("");
     textIva.setText("");
     textNumFra.setText("");
     textNumProv.setText("");
     textTotal.setText("");
     textTipo.setText("21");
    
     comboNomProv.setSelectedIndex(0);
     comboConcep.setSelectedIndex(0);
     
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void textBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBaseActionPerformed
       
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

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
      // VALIDACION
      boolean validado = true;
      int trimIn = 0, trim = 0, anyo = 0;
       BDControl bd = new BDControl();
      //Validar fecha
      
      int anno = jCalendarCombo1.getCalendar().get(Calendar.YEAR);
      int mes = jCalendarCombo1.getCalendar().get(Calendar.MARCH);
      mes++;
      int dia = jCalendarCombo1.getCalendar().get(Calendar.DAY_OF_MONTH);
      
      if(mes<=3 && mes >0){
          trimIn = 1;
      }
      if(mes>3 && mes<=6){
          trimIn = 2;
      }
      if(mes>6 && mes<=9){
          trimIn = 3;
      }
      if(mes>9 && mes<=12){
          trimIn = 4;
      }
                
        try {
            String periodo = bd.leePeriodo();
            
            String t =periodo.substring(8);
            String a =periodo.substring(0,4);
            trim = Integer.parseInt(t);
            anyo = Integer.parseInt(a);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex, "Error al leer periodo",0);
            validado=false;
        }
        if(trimIn != trim || anno != anyo){
            JOptionPane.showMessageDialog(null,"Esta fecha no corresponde al período en el que estamos trabajando", "Atención",0);
            validado=false;
        }
        
      
      if(comboNomProv.getSelectedIndex()== 0){
          JOptionPane.showMessageDialog(null,"Debes seleccionar un Proveedor", "Atención",2);
          validado=false;
      }
      if(comboConcep.getSelectedIndex()== 0){
          JOptionPane.showMessageDialog(null,"Debes seleccionar un Concepto", "Atención",2);
          validado=false;
      }
     String contenidoNumFra = textNumFra.getText();
    
      if(contenidoNumFra.equals("")){
          JOptionPane.showMessageDialog(null,"Debes Introducir un número de factura", "Atención",2);
          validado=false;
      }
      String contenidoBase = textBase.getText();
      if(contenidoBase.equals("")){
          JOptionPane.showMessageDialog(null,"Debes Introducir un valor en Base factura", "Atención",2);
          validado = false;
      }else{
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
           JOptionPane.showMessageDialog(null,"Use un . para la separación de los decimales ","Debe introducir un  valor numérico",2);
           textBase.setText("");
           validado=false;
       }
      }
      //FIN VALIDACION
      //Si la validación es correcta guardamos en la base de datos
      if(validado==true){
          //CONVERTIMOS FECHA A STRING Y FORMATEAMOS A DOS DIGITOS
         
          String sDia = String.format("%02d",dia);
         
          String sMes = String.format("%02d",mes);
          
          String fechaOrden = Integer.toString(anno)+ sMes + sDia;
          
          
          
          String fechaFactura = sDia+ "/" +sMes+ "/" + Integer.toString(anno);
          int id_proveedor = Integer.valueOf(textNumProv.getText());
          String numFactura = textNumFra.getText();
          float bas = Float.valueOf(textBase.getText());
          float tipo = Float.valueOf(textTipo.getText());
          float iva = Float.valueOf(textIva.getText());
          float total = Float.valueOf(textTotal.getText());
          String id_cuenta = String.valueOf(comboCuentas.getSelectedItem());
          String vto = textVto.getText();
          try { 
              bd.guardaFactRecib( id_proveedor,  fechaFactura,  fechaOrden,  numFactura,  id_cuenta, bas,  tipo,  iva,  total,  vto );
          } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex,"Error al guardar factura",2);
          }
     
          //REESCRIBE LA TABLA DE FACTURAS RECIBIDAS
          this.dispose();
       
      
      
        try {
             frameFrasRecib ffr = new frameFrasRecib();
             ffr.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(frameContabilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void comboConcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboConcepActionPerformed
      int item = comboConcep.getSelectedIndex();
      comboCuentas.setSelectedIndex(item);
    }//GEN-LAST:event_comboConcepActionPerformed

    private void comboEditarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEditarProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEditarProvActionPerformed

    private void textEditNumFraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEditNumFraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEditNumFraActionPerformed

    private void botonEditarFraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarFraActionPerformed
     frameEditarFrasRec fefr= new frameEditarFrasRec();
        try {
            frameFrasRecib ffr = new frameFrasRecib();
            Object ob = ffr.comboNomProv.getSelectedItem();
            String pavelo = textBase.getText();
            fefr.base = pavelo;
            fefr.setVisible(true);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(frameFrasRecib.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
    }//GEN-LAST:event_botonEditarFraActionPerformed

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
    private javax.swing.JButton botonEditarFra;
    private javax.swing.JButton botonFactEmi;
    private javax.swing.JButton botonFrasRec;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonProveed;
    private org.freixas.jcalendar.JCalendarCombo calendarEditFra;
    private javax.swing.JComboBox<String> comboConcep;
    private javax.swing.JComboBox<String> comboCuentas;
    private javax.swing.JComboBox<String> comboEditNumProv;
    private javax.swing.JComboBox<String> comboEditarProv;
    private javax.swing.JComboBox<String> comboNomProv;
    private javax.swing.JLabel etiqTitulo;
    private org.freixas.jcalendar.JCalendarCombo jCalendarCombo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tablaFR;
    private javax.swing.JTextField textBase;
    private javax.swing.JTextField textEditNumFra;
    private javax.swing.JTextField textIva;
    private javax.swing.JTextField textNif;
    private javax.swing.JTextField textNumFra;
    private javax.swing.JTextField textNumProv;
    private javax.swing.JTextField textTipo;
    private javax.swing.JTextField textTotBaseTrim;
    private javax.swing.JTextField textTotIvaTrim;
    private javax.swing.JTextField textTotal;
    private javax.swing.JTextField textTotalTrim;
    private javax.swing.JTextField textVto;
    // End of variables declaration//GEN-END:variables

    private String proveedores(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

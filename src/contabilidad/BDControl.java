
package contabilidad;

import java.sql.*;
import javax.swing.JOptionPane;
 
public  class BDControl {
    //INICIAMOS CONSTANTES DE CLASE PARA DEFINIR PARAMETROS DE CONEXION A BD
          static final String url = "jdbc:mysql://localhost:3306/contadesarrollo";
          static final String usuario = "root";
          static final String contras = "";
    ////////////////////////////////////////////////////////////////////////////
   //METODO QUE EJECUTA CONSULTAS SELECT 
    public static ResultSet ejecutaSql(String consulta){
        
         
        
     try {
            // 1 CREAR CONEXION          
            
            Connection miConexion = DriverManager.getConnection(url, usuario, contras);
                        
            //2 CREAR OBJETO STATEMENT
            
            Statement miStatement = miConexion.createStatement();
            
            //EJECUTAR SQL
            
            ResultSet miResultset = miStatement.executeQuery(consulta);
         
            //miStatement.close();
           
           
             return miResultset;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "No se ha podido ejecutar la consulta SQL", 0, null);
            
        }
    
       return null; 
    }//fin método ejecutaConsultas 
    ///////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    
    //ESTE METODO SE UTILIZA PARA LAS CONSULTAS UPDATE Y CREATE
     public static void ejecutaUpdate(String sql){
          try {
            // 1 CREAR CONEXION          
            
            Connection miConexion = DriverManager.getConnection(url, usuario, contras);
                        
            //2 CREAR OBJETO STATEMENT
            
            Statement miStatement = miConexion.createStatement();
            
            //EJECUTAR SQL
            try{
            miStatement.executeUpdate(sql);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e, "No se ha podido ejecutar la consulta Update SQL", 0, null);
            }
            //miStatement.close();
           
           
            
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            
        }
     }//FIN EJECUTA UPDATE
    /////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
     public static String leePeriodo() throws SQLException{
      
        String resultado="" ;
    
        ResultSet rs = ejecutaSql("SELECT * FROM periodo");
             
        
        
         
          //RECORRER O LEER RESULTSET
            
                while(rs.next()){
                     resultado = rs.getString("id_periodo");
                    
              }
       
          
        return resultado;
    }//FIN leeperiodo
    /////////////////////////////////////////////////////////////////////////////////
     ////////////////////////////////////////////////////////////////////////////////
     public static void guardaPeriodo(String periodo){
         
          
        String sql ; 
        sql = "UPDATE periodo SET id_periodo = '" + periodo + "'";
        
         
        
     try {
            // 1 CREAR CONEXION          
            
            Connection miConexion = DriverManager.getConnection(url, usuario, contras);
                        
            //2 CREAR OBJETO STATEMENT
            
            Statement mS = miConexion.createStatement();
            
            //EJECUTAR UPDATE
           int b = mS.executeUpdate(sql);
           //mS.close();           
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            
        }
     }//FIN GUARDA PERIODO
     ///////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////
     public static ResultSet leeClientes(){
         ResultSet rs = null;
         String sql = "SELECT * FROM cliente";
         rs = ejecutaSql(sql);
         return rs;
     }
     ///////////////////////////////////////////////////////////////////
     
     public static ResultSet leeFacturasEmitidas() throws SQLException{
         ResultSet miResultset =null;
         String periodo = leePeriodo();
         String sql="SELECT * FROM factemi" + periodo + " ORDER BY fechaOrden";
         miResultset = ejecutaSql(sql);
         
         return miResultset;
     }//FINAL LEEFACTURASEMITIDAS
     //////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////
     
     public static ResultSet leeFacturasRecibidas() throws SQLException{
          ResultSet miResultset =null;
         String periodo = leePeriodo();
         String sql="SELECT * FROM factrec" + periodo + " ORDER BY fechaOrden";
         miResultset = ejecutaSql(sql);
         
         return miResultset;
     }//final LEEFACTURASRECIBIDAS
     /////////////////////////////////////////////////////////////////////////
     ////////////////////////////////////////////////////////////////////////
     
     public static void creaTrimestre(String factEmis, String factRecs){
         //CREAMOS TABLA FACTURAS EMITIDAS
         
        String sql="  CREATE TABLE IF NOT EXISTS " + factEmis + " (id_cliente INT(6) NOT NULL,fechaFactura varchar(11) NOT NULL,fechaOrden varchar(11) NOT NULL,";
	sql = sql + "numFactura varchar(25) NOT NULL,id_cuenta varchar(7) NOT NULL,base float(10) NOT NULL,tipo float(2) NOT NULL,";
        sql = sql + "iva float(10) NOT NULL,total float(10) NOT NULL,vto varchar(11),material float(10),mo float(10))";
        
       ejecutaUpdate(sql); 
       //CREAMOS FACTURAS RECIBIDAS
       sql = "CREATE TABLE IF NOT EXISTS " + factRecs + "(id_proveedor INT(6) NOT NULL,fechaFactura varchar(11) NOT NULL,fechaOrden varchar(11) NOT NULL,";
       sql = sql + "numFactura varchar(25) NOT NULL,id_cuenta varchar(7) NOT NULL,base float(10) NOT NULL,tipo float(2) NOT NULL,";
       sql = sql + "iva float(10) NOT NULL,total float(10) NOT NULL,vto varchar(11))";
       ejecutaUpdate(sql);
             }//FIN CREA TRIMESTRE
     
     /////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////
     public static ResultSet leeProveedores() throws SQLException{
         ResultSet resultado ;
         String sql = "SELECT * FROM proveedor ORDER BY nombre";        
         resultado = ejecutaSql(sql);
        return resultado; 
     }//FIN LEEPROVEEDORES
     
     ////////////////////////////////////////////////////////////////////////
     /////////////////////////////////////////////////////////////////////////
     
     public static ResultSet leeCuentas(){
         ResultSet cuentas = ejecutaSql("SELECT * FROM cuenta");
         return cuentas;
     }//FINAL LEECUENTAS
     
     /////////////////////////////////////////////////////////////////////////
     ////////////////////////////////////////////////////////////////////////
     
     public static void guardaFactRecib(int id_proveedor, String fechaFactura, String fechaOrden, String numFra, String id_cuenta, float base, float tipo, float iva, float total, String vto ) throws SQLException{
        String periodo = leePeriodo();
         String factrec = "factrec" + periodo;
        
        String sql="INSERT INTO " + factrec +" (id_proveedor,fechaFactura ,fechaOrden,numFactura,id_cuenta,base,tipo,iva,total,vto)"; 
            
         sql = sql + " VALUES('" + id_proveedor +"', '" + fechaFactura + "', '"+ fechaOrden  + "', '" + numFra + "', '"+ id_cuenta + "',' "+ base + "', '"+ tipo + "', '"+ iva + "', '"+ total + "', '"+ vto +"')";
        
             ejecutaUpdate(sql);
         
         
     }
     
     //////////////////////////////////////////////////////////////////////
     /////////////////////////////////////////////////////////////////////
      public static void guardaFactEmitidas(int id_cliente, String fechaFactura, String fechaOrden, String numFactura, String id_cuenta, float base, float tipo, float iva, float total, String vto, float material, float mo ) throws SQLException{
        String periodo = leePeriodo();
         String factemi = "factemi" + periodo;
        
        String sql="INSERT INTO " + factemi +" (id_cliente,fechaFactura,fechaOrden,numFactura,id_cuenta,base,tipo,iva,total,vto,material,mo)"; 
            
         sql = sql + " VALUES('" + id_cliente +"', '" + fechaFactura + "', '"+ fechaOrden  + "', '" + numFactura + "', '"+ id_cuenta + "',' "+ base + "', '"+ tipo + "', '"+ iva + "', '"+ total + "', '"+ vto +"' , '" + material + "' , '" + mo +"')";
        
             ejecutaUpdate(sql);
         
         
     }
     
}

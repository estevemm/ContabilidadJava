
package contabilidad;

import java.sql.*;
 
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
            System.out.print(e.getMessage());
            
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
            
            miStatement.executeUpdate(sql);
         
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
         ResultSet cuentas = ejecutaSql("SELECT * FROM cuenta ORDER BY concepto");
         return cuentas;
     }//FINAL LEECUENTAS
     
     
     
     
}

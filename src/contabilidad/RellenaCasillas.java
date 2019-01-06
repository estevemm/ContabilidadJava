/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

/**
 *
 * @author Esteve
 */
public class RellenaCasillas {
    
    public static String[] rellenaCamposConta() throws SQLException{
        //LEEMOS BASE DE DATOS PARA HACER LOS CÁLCULOS
       //LEEMOS FACTURAS EMITIDAS
       BDControl bd = null;
       ResultSet factemi = bd.leeFacturasEmitidas();
       float base=0, iva =0, total=0;
       float totalBase=0, totalIva=0, totalTotal=0;
       
        while(factemi.next()){
            base = factemi.getFloat("base");
            totalBase = totalBase + base;
            
            iva = factemi.getFloat("iva");
            totalIva = totalIva + iva;
            
            total = factemi.getFloat("total");
            totalTotal = totalTotal + total;           
        }
          
        //LEEMOS FACTURAS RECIBIDAS
         ResultSet factrec = bd.leeFacturasRecibidas();
       float baseRec=0, ivaRec =0, totalRec=0;
       float totalBaseRec=0, totalIvaRec=0, totalTotalRec=0;
       
        while(factrec.next()){
            baseRec = factrec.getFloat("base");
            totalBaseRec = totalBaseRec + baseRec;
            
            ivaRec = factrec.getFloat("iva");
            totalIvaRec = totalIvaRec + ivaRec;
            
            totalRec = factrec.getFloat("total");
            totalTotalRec = totalTotalRec + totalRec;  
            
           
        }
            
        float totBase, totIva, totTot;
        totBase = totalBase-totalBaseRec;
        totIva = totalIva-totalIvaRec;
        totTot = totalTotal-totalTotalRec;
        //DEJAMOS 2 DECIMALES
        DecimalFormat formato1 = new DecimalFormat("#.00");
        
        String respuesta[] = {formato1.format(totalBase), formato1.format(totalIva), formato1.format(totalTotal),formato1.format(totalBaseRec), formato1.format(totalIvaRec),formato1.format(totalTotalRec) ,formato1.format(totBase) , formato1.format(totIva), formato1.format(totTot)};
        
      return respuesta;
    }
    
    
    
    
    
}

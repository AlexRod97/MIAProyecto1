/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Bryan Mejía
 */
public class Utilidades {
   
    /**
     * Ordena los datos y los introduce en Master
     * @param bitacora
     * @param Master
     * @return
     * @throws IOException 
     */
    public static File BubbleSort(File bitacora, File Master) 
            throws IOException{
        
        //tomar un registro de la bitacora, ordenar e introducir
        FileReader bitReader = new FileReader(bitacora);
        BufferedReader bitBuff = new BufferedReader(bitReader);
 
        while(!bitBuff.equals(null)){
            
            FileReader MasterReader = new FileReader(Master);
            BufferedReader MasterBuff = new BufferedReader(MasterReader);
            
            String x = bitBuff.readLine();
            String[] datosBuff = x.trim().split("\\|");
            boolean flag = false;
            
            while(flag == false){
                
                int offset = 0;
                String y = MasterBuff.readLine();
                
                if (!y.equals(null)) {
                    
                 String[] datosMaster = y.trim().split("\\|");
                 
                 int min = datosMaster[0].compareTo(datosBuff[0]);
                 
                 switch(min){
                     
                     //es mas pequeño Master
                     case -1:
                         offset += x.length();
                         break;
                      
                     //es mas grande Master
                     case 1:
                         MasterBuff.close();
                         
                         FileWriter fw = new FileWriter(Master);
                         BufferedWriter bw = new BufferedWriter(fw);
                         
                         //escribe al archivo y accede a posicion mediante
                         //un offset
                         bw.write(x, offset, x.length());
                         bw.close();
                         flag = true;
                        break;
                    }
                } 
            }
            
        }
       return Master;
    }
}
  

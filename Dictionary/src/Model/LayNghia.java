/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Base64;

/**
 *
 * @author Minh Tri
 */
public class LayNghia {
    
    public static String LayNghiaTu(long offset, long size, String fileName)
    {
        
        if (!((new java.io.File(fileName)).exists())) { 
            return "File: " + fileName + " does not exist"; 
        } 
        String strMeaning = "not found"; 
        DataInputStream dt = null; 
        try { 
            
            dt = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName))); 
            dt.skip(offset); 
            byte[] bt = new byte[(int) size]; 
            dt.read(bt, 0, (int) size); 
            strMeaning = new String(bt, "UTF8");
        } catch (Exception ex) { 
        } finally { 
            if (dt != null) { 
                try { 
                    dt.close();                     
                } catch (Exception ex) { 
                } 
            } 
        } 
        return strMeaning;
    }
    
    
    public static void main(String args[]) throws IOException
    {
//        NapTu.ThucHien(fileName);
//        String word = "cat";
//        
//        NapTu.Gan_offset_size(word);
//        //String meaning = "not found";
////        byte[] meaning = LayNghiaTu(NapTu.Lay_Offset(), NapTu.Lay_Size()).getBytes();
////        String encoded = Base64.getEncoder().encodeToString(meaning);
////        byte[] decoded = Base64.getDecoder().decode(encoded);
////        String s = new String(decoded);
////        for(int i = 0; i < s.length(); i++)
////        {
////            System.out.print(s.charAt(i));
////        }
//        String meaning = LayNghiaTu(NapTu.Lay_Offset(), NapTu.Lay_Size());
//        for(int i = 0; i < meaning.length(); i++)
//        {
//            System.out.print(meaning.charAt(i));
//        }
////        FileOutputStream fo = new FileOutputStream("out.txt");
////        OutputStreamWriter osw = new OutputStreamWriter(fo, "utf-8");
////        osw.write(meaning);
////        osw.flush();
////        fo.close();
////        
////        
////        FileInputStream fi = new FileInputStream(file);
////        InputStreamReader isr = new InputStreamReader(fi, "utf-8");
////        BufferedReader br = new BufferedReader(isr);
////        String sR = "", sNewLine;
////
////        while ((sNewLine = br.readLine()) != null){
////            sR += sNewLine + "\n";
////        }
//        //fi.close();
        
        
        
    }
    
}

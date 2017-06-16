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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Tri
 */
public class NapTu {
    private static Vector m_word = new Vector();
    private static Vector m_data = new Vector();
    private static long offset;
    private static long size;
    
    public static void ThucHien(String fileName) throws FileNotFoundException, IOException
    {
        m_word.clear();
        m_data.clear();
        File file = new File(fileName);
        file.createNewFile();
        FileInputStream fis;
        fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        String word = "";
        String sWord = "";
        String sData = "";
        
        while ((line = br.readLine()) != null) 
        {
            if(line.length() >= 2)
            {
                word = line;
   
                String[] t = word.split("\t");
                m_word.add(t[0]);
                String c = t[1]+"\t"+t[2];
                m_data.add(c);
            }
        }        
    }
    
    public static long LayGiaTri10(String s)
    {
        String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        long decValue = 0;
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = 0; j < base64.length(); j++)
            {
                if(s.charAt(i) == base64.charAt(j))
                {
                    decValue += Math.pow(64, s.length()-i-1)*j;
                }
            }
        }
        return decValue;
    }
    
    public static void Gan_offset_size(String word)
    {
        String w_offset;
        String w_size;
        long chiso = ChiSoTu(word);
        String data = (String) m_data.elementAt((int) chiso);
        int pos = data.indexOf("\t"); 
        w_offset = data.substring(0, pos);
        w_size = data.substring(pos+1, data.length());
        
        offset = LayGiaTri10(w_offset);
        size = LayGiaTri10(w_size);
    }
    
    public static long ChiSoTu(String word)
    {
        long first = 0;
        long last = m_word.size()-1;
        long mid;
        do
        {
            mid = (first + last) / 2; 
            int cmp = word.compareTo((String) m_word.get((int)mid));
            if (cmp == 0) { 
                return mid; // return index if found 
            } 
            if (cmp > 0) { 
                first = mid + 1; 
            } else { 
                last = mid - 1; 
            } 
        }while(first <= last);
        
        
        first = -1;
        return first;
    }
    
    
    
    
    public static Vector Lay_Word()
    {
        return m_word;
    }
    public static long Lay_Offset()
    {
        return offset;
    }
    public static long Lay_Size()
    {
        return size;
    }
    
    
    public static void Gan_offset_size_tuyentinh(String word)
    {
        String w_offset;
        String w_size;
        //
        int chiso = -1;
        
        for(int i = 0; i < m_word.size(); i++)
        {
            if(word.compareTo((String) m_word.get(i)) == 0)
            {
                chiso = i;
                break;
            }
        }
        
        String data = (String) m_data.elementAt((int) chiso);
        int pos = data.indexOf("\t"); 
        w_offset = data.substring(0, pos);
        w_size = data.substring(pos+1, data.length());
        
        offset = LayGiaTri10(w_offset);
        size = LayGiaTri10(w_size);
    }
    
    public static void main(String args[]) throws IOException
    {
        ThucHien("anhviet_index.index");
        Gan_offset_size("bowman");
        System.out.println("Data từ bowman: ");
        System.out.println(offset+" - "+size);
        System.out.println();
        Gan_offset_size("bowshot");
        System.out.println("Data từ bowpot: ");
        System.out.print(offset+" - "+size);
        
    }
    
    
    
}

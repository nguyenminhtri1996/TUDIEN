/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import static Model.LayNghia.LayNghiaTu;
import java.io.IOException;
/**
 *
 * @author Minh Tri
 */
public class HienThi {
    
    public HienThi(JTextField txt_search, JRadioButton rdAnhViet, JRadioButton rdVietAnh, JTextPane txtMeaning, JList<String> list_Word, JLabel jHinhAnh, Vector dataWordEnglish_translated, Vector dataWordViet_translated, Vector wordlistEnglish_translated, Vector wordlistViet_translated)
    {
        
        
        String word = txt_search.getText();
        word = word.toLowerCase();
        //Search tu dien Viet Anh
        if(rdAnhViet.isSelected() || rdVietAnh.isSelected())
        {
            String meaning = "";
            if(rdVietAnh.isSelected())
            {
                try {
                    NapTu.ThucHien("vietanh_index.index");
                    NapTu.Gan_offset_size_tuyentinh(word);
                           
                    meaning = LayNghiaTu(NapTu.Lay_Offset(), NapTu.Lay_Size(), "dulieu_vietanh.txt");
                    String[] temp = meaning.split("@");
                    meaning = "";
                    for(int i = 1; i < temp.length; i++)
                    {
                        meaning += temp[i];
                    }                                      
                } catch (IOException ex) {
                    //Logger.getLogger(Frame_Dic.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
            else if(rdAnhViet.isSelected())
            {
                try {
                    NapTu.ThucHien("anhviet_index.index");
                    NapTu.Gan_offset_size(word);
                          
                    meaning = LayNghiaTu(NapTu.Lay_Offset(), NapTu.Lay_Size(), "dulieu_anhviet.txt");
                    String[] temp = meaning.split("@");
                    meaning = "";
                    for(int i = 1; i < temp.length; i++)
                    {
                        meaning += temp[i];
                    }                                                     
                } catch (IOException ex) {
                    //Logger.getLogger(Frame_Dic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            // Xử lý chuỗi kết quả
            StringBuilder my = new StringBuilder(meaning);
            for(int j = 0; j < my.length(); j++)
            {
                if("+".equals(Character.toString(my.charAt(j))))
                {                                                     
                    my.replace(j, j+1, "\n");
                }
                                
            }                
            meaning = my.toString();              
            String[] my_temp = meaning.split("\n");
            my_temp[0] = "<font color=\"#FF0000\"><b>"+my_temp[0]+"</b></font>";
            for(int i = 1; i < my_temp.length; i++)
            {
                // TODO
                if(my_temp[i].charAt(0) == '*')
                {
                    my_temp[i] = "<font color=\"#0012B3\">"+my_temp[i]+"</font>";
                }
                if(my_temp[i].charAt(0) == '=')
                {
                    my_temp[i] = "<font color=\"#FF0089\">"+my_temp[i].substring(1, my_temp[i].length())+"</font>";
                }
            }
            meaning = "";
            for(int i = 0; i < my_temp.length; i++)
            {
                meaning += my_temp[i]+"<br>";
            }
            txtMeaning.setContentType("text/html");
            txtMeaning.setText(meaning);
            txtMeaning.setCaretPosition(0);
            
            if(rdAnhViet.isSelected())
            {
                wordlistEnglish_translated.add(word);
                list_Word.setListData(wordlistEnglish_translated);
                dataWordEnglish_translated.add(meaning);
            }
            if(rdVietAnh.isSelected())
            {
                wordlistViet_translated.add(word);
                list_Word.setListData(wordlistViet_translated);  
                dataWordViet_translated.add(meaning);
            }
            
            
            
            try {
                //Hiện Hình Ảnh
                URLHinhAnh.LayLink(word, jHinhAnh);
            } catch (IOException ex) {
                //Logger.getLogger(Frame_Dic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn kiểu từ điển", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}

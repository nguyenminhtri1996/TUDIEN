/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Minh Tri
 */
public class URLHinhAnh {
    public static void LayLink(String word, JLabel jHinhAnh) throws MalformedURLException, IOException
    {
        String chuoi_url = "";
        word = word.toLowerCase();
        char kitudau = word.charAt(0);
        chuoi_url = "http://3.vndic.net/images/dict/"+kitudau+"/"+word+".gif";
        URL url = new URL(chuoi_url);
        BufferedImage img = ImageIO.read(url);       
        ImageIcon image = new ImageIcon(img);       
        Image IMG = image.getImage();
        Image newimg = IMG.getScaledInstance(300, 250,  java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newimg);        
        jHinhAnh.setIcon(image);               
    }
}

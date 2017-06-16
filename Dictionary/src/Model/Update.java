/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Minh Tri
 */
public class Update {
    public static String MaHoa(long n)
    {
        String result = "";
        String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        int thuong = (int) (n/63);
        int du = (int) (n%63);
        for(int i = 0; i < thuong; i++)
        {
            result += "/";
        }
        result += base64.charAt(du);
        return result;
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
    public static void main(String args[])
    {
        
        //System.out.println(MaHoa(99));
        System.out.println(LayGiaTri10("/k"));
    }
}

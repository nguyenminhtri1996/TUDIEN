/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author Minh Tri
 */
public class Speak {
    public static void read(String word)
    {
        String VOICENAME="kevin16";
        Voice voice;
        VoiceManager vm=VoiceManager.getInstance();
        voice=vm.getVoice(VOICENAME);
        voice.allocate();
        try
        { 
            voice.speak(word);
        }catch(Exception e)
        {
        }
        
    }
}

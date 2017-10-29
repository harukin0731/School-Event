
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harukin
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        try {
            new TopScreen();
            //new GUIConfigsss();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
}

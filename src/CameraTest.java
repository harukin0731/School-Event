/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author harukin
 */
public class CameraTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    void CameraTest(String[] args)throws IOException {
        // TODO code application logic here
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            System.out.println("Webcam : " + webcam.getName());
            webcam.open();
            BufferedImage image = webcam.getImage();
            ImageIO.write(image, "PNG", new File("pictures/webcam-capture.png"));
        } else {
            System.out.println("Failed: Webcam Not Found Error");
        }
    }
    
}

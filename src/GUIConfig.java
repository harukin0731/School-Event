/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harukin
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.Window.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.logging.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;




class おえかき画面 extends GUIConfig{
    JPanel  panel1 = new JPanel(),
            panel2 = new JPanel(),
            panel3 = new JPanel(),
            panel4 = new JPanel();
    public おえかき画面(){
        addWindowListener(this);
        setTitle("おえかき");
        setLocation(0,0);
	setSize(1200,720);
        setVisible(true);
    }
}
class GUIConfig extends JFrame implements WindowListener,ActionListener,ChangeListener,MouseListener,MouseInputListener,Printable  {
    String dirnom = System.getProperty("file.separator");
    public void windowClosing(WindowEvent arg0) {dispose();}
    public void windowActivated(WindowEvent arg0){}
    public void windowClosed(WindowEvent arg0){}
    public void windowDeactivated(WindowEvent arg0){}
    public void windowDeiconified(WindowEvent arg0){}
    public void windowIconified(WindowEvent arg0){}
    public void windowOpened(WindowEvent arg0){}
    public void actionPerformed(ActionEvent arg0){}
    public void stateChanged(ChangeEvent e) {}
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void paintComponent(Graphics g) {}
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
class GraphicConfig   extends JPanel implements MouseListener,MouseMotionListener,Printable{
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


/*class GUIConfigsss extends Frame implements WindowListener,ActionListener {
    private Panel panel1,panel2;
    private Button deleteButton1,Button;
    private TextArea text;
    private Image img;
    
    
    public GUIConfigsss()throws IOException{
        addWindowListener(this);
        setTitle("図形描画");
        setLocation(300,200);
	setSize(640,480);
        setVisible(true);
        panel1=new Panel();
        panel2=new Panel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        add(panel1,"West");
        add(panel2,"South");
        deleteButton1=new Button("＼(^o^)／");
        deleteButton1.addActionListener(this);
        Button=new Button("＼(^o^)／");
        panel1.add(deleteButton1);
        panel2.add(Button);
        Label label=new Label("色ぉぉぉぉぉ！！");
        panel2.add(label);
        text=new TextArea("ウヲァァァァァァァァァァァ！！！",1,100,1);
        add(text);         
    }
    public void windowClosing(WindowEvent arg0) {
        dispose();
    }
    @Override
    public void windowActivated(WindowEvent arg0){}
    public void windowClosed(WindowEvent arg0){}
    public void windowDeactivated(WindowEvent arg0){}
    public void windowDeiconified(WindowEvent arg0){}
    public void windowIconified(WindowEvent arg0){}
    public void windowOpened(WindowEvent arg0){}
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource()==deleteButton1){
            System.out.println("うわぁぁぁぁぁぁぁｌ！！！！！");        
        }
    }
}*/
class GUIの雛形 extends GUIConfig{
    public GUIの雛形(){
        addWindowListener(this);
        setTitle("タイトル");
        setLocation(0,0);
	setSize(1200,720);
        setVisible(true);
    }
}
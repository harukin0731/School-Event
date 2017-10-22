/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harukin
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.Window.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.logging.*;
class TopScreen extends GUIConfig{
    
    JPanel  panel  = new JPanel(),
            panel2 = new JPanel();
    
    JButton StartButton = new JButton("はじめる→"),
            AboutButton = new JButton("このソフトウェアについて"),
            NextButton  = new JButton("次へ");
    
    JLabel  text  = new JLabel("情報電子科三年生制作画像加工ソフトウェア",JLabel.CENTER),
            label = new JLabel("右のボタンを押して撮影を開始してください。");
    
    Image   img;
    
    public TopScreen()throws IOException{
        addWindowListener(this);
        setTitle("(´・ω・｀) by 情報電子科3年生！！");
        setLocation(0,0);
	setSize(1200,720);
        setVisible(true);
        add(panel,"South");
        AboutButton.addActionListener(this);
        StartButton.addActionListener(this);
        panel.setBackground(Color.white);
        panel.add(AboutButton);
        panel.add(label);
        add(text);
        panel.add(StartButton);
        panel.add(NextButton);
    } 
    
    void test(){
        remove(text);
        panel.remove(StartButton);
        remove(panel);
        add(panel2,"North");
        panel2.add(NextButton);
    }
    
    ///オーバーライドぉぉ
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource() == AboutButton){
            System.out.println("＼(^o^)／");
            new このソフトウェアについて();      
        }
        
        if(arg0.getSource() == StartButton){
            System.out.println("＼(^o^)／");
            test();
        }
    }
}

class このソフトウェアについて extends GUIConfig{
    JPanel      Close = new JPanel();
    
    JButton     close = new JButton("閉じる");
    
    JTextArea   text = new JTextArea(""
                + "制作：情報電子科三年生　向井晴紀\n"
                + "使用ソフト：NetBeansIDE for Linux\n"
                + "このプログラムはMITライセンスの元で制作されているわけではありません。"
                ,20,20); 
    
    public このソフトウェアについて(){
        addWindowListener(this);
        close.addActionListener(this);
        setTitle("このソフトウェアについて");
        setLocation(300,300);
	setSize(600,300);
        setVisible(true);
        add(text);
        add(Close,"South");
        Close.add(close);
    }
    ///オーバーライドぉぉ
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource()==close){
            dispose();
        }
    }
}

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
class GUIConfig extends JFrame implements WindowListener,ActionListener {
    public void windowClosing(WindowEvent arg0) {dispose();}
    public void windowActivated(WindowEvent arg0){}
    public void windowClosed(WindowEvent arg0){}
    public void windowDeactivated(WindowEvent arg0){}
    public void windowDeiconified(WindowEvent arg0){}
    public void windowIconified(WindowEvent arg0){}
    public void windowOpened(WindowEvent arg0){}
    public void actionPerformed(ActionEvent arg0){}
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
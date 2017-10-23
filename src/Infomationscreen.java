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
class Informationscreen extends GUIConfig{
    JPanel      Close = new JPanel();
    
    JButton     close = new JButton("閉じる");
    
    JLabel label = new JLabel();
    
    ImageIcon icon = new ImageIcon("./Logo-face.png");
    
    JTextArea   text = new JTextArea(""
                + "制作：情報電子科三年生　向井晴紀\n"
                + "使用ソフト：NetBeansIDE for Linux\n"
                + "このプログラムはMITライセンスの元で制作されているわけではありません。"
                ,20,20); 
    
    public Informationscreen(){
        addWindowListener(this);
        close.addActionListener(this);
        label.setIcon(icon);
        setTitle("このソフトウェアについて");
        setLocation(300,300);
	setSize(600,300);
        setVisible(true);
        add(text);
        add(Close,"South");
        Close.add(close);
        //Close.add(label);
    }
    ///オーバーライドぉぉ
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource()==close){
            dispose();
        }
    }
}
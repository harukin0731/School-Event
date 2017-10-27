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
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Exception2nd extends GUIConfig {
    JLabel label = new JLabel("カメラが接続されていないようです。カメラの接続を確認してください。");
    JButton close = new JButton("閉じる");
    Exception2nd(){
        addWindowListener(this);
        close.addActionListener(this);
        setLayout(new BorderLayout());
        setTitle("ハードウェアエラー");
        setLocation(0,0);
	setSize(600,200);
        setLocationRelativeTo(null);
        add(label);
        add(close,"South");
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource()==close){
            dispose();
        }
    }
}

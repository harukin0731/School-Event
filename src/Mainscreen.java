
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harukin
 */

class TopScreen extends GUIConfig{
    
    JTabbedPane tabbedpane = new JTabbedPane();
    //一段階目のGUI
    JPanel    first  = new JPanel(),
              first2 = new JPanel(),
              panel2 = new JPanel();
    
    JButton   StartButton = new JButton("はじめる→"),
              AboutButton = new JButton("このソフトウェアについて");
              
    ImageIcon icon = new ImageIcon("./Logo-face.png");
    
    JLabel    text   = new JLabel("情報電子科三年生制作画像加工ソフトウェア",JLabel.CENTER),
              label  = new JLabel("右のボタンを押して撮影を開始してください。");
    
    Image     img;
    
    //ニ段階目のGUI
    JPanel    second    = new JPanel(),
              second2_1 = new JPanel(),
              second2_2 = new JPanel();
    
    JLabel    Announcetext2  = new JLabel("設定をします。"),
              Secondlabel    = new JLabel("お好みに設定をしてください。");
    
    JButton   NextButton2 = new JButton("次へ"),
              BackButton2 = new JButton("戻る");
    
    //三段階目のGUI
    JPanel third = new JPanel(),
           third2_1 = new JPanel(),
           third2_2 = new JPanel();
    
    JLabel    Announcetext3  = new JLabel("撮影をします。"),
              thirdlabel    = new JLabel("右のボタンを押して撮影を開始してください。");
    
    JButton   NextButton3 = new JButton("次へ"),
              BackButton3 = new JButton("戻る");
    
    
    public TopScreen()throws IOException{
        addWindowListener(this);
        setTitle("(´・ω・｀) by 情報電子科3年生！！");
        setLocation(0,0);
	setSize(1200,720);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        //１枚目
        tabbedpane.addTab("はじめに",add(first));
        first.setLayout(new BorderLayout());
        first.add(text);
        first.add(first2,"South");
        first2.setBackground(Color.LIGHT_GRAY);
        first2.add(label);
        first2.add(AboutButton);
        AboutButton.addActionListener(this);
        first2.add(StartButton);
        StartButton.addActionListener(this);
        //２枚目
        tabbedpane.addTab("次に",add(second));
        second.setLayout(new BorderLayout());
        second.add(second2_2,"South");
        second.add(second2_1);
        second2_1.add(Announcetext2);
        second2_2.setBackground(Color.LIGHT_GRAY);
        second2_2.add(BackButton2);
        BackButton2.addActionListener(this);
        second2_2.add(label);
        second2_2.add(NextButton2);
        NextButton2.addActionListener(this);
        //３枚目
        tabbedpane.addTab("撮影",add(third));
        third.setLayout(new BorderLayout());
        third.add(third2_2,"South");
        third.add(third2_1);
        third2_1.add(Announcetext3);
        third2_2.setBackground(Color.LIGHT_GRAY);
        third2_2.add(BackButton3);
        BackButton3.addActionListener(this);
        third2_2.add(label);
        third2_2.add(NextButton3);
        NextButton3.addActionListener(this);
        
        
        
        
        
        add(tabbedpane);
        setVisible(true);
        
        
        
    } 
    
    ///オーバーライドぉぉ
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource() == AboutButton){
            new Informationscreen();      
        }
        
        if(arg0.getSource() == StartButton){
            tabbedpane.setSelectedIndex(1);
        }
        if(arg0.getSource() == NextButton2){
            tabbedpane.setSelectedIndex(2);
        }
        if(arg0.getSource() == BackButton2){
            tabbedpane.setSelectedIndex(0);
        }
        if(arg0.getSource() == NextButton3){
            tabbedpane.setSelectedIndex(2);
        }
        if(arg0.getSource() == BackButton3){
            tabbedpane.setSelectedIndex(1);
        }
    }
}
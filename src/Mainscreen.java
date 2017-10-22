
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        add(panel2,"North");
        panel2.setVisible(false);
        panel2.add(NextButton);
    } 
    
    void test(){
        /*
        System.out.println("testに入ったぜ！");
        remove(text);
        System.out.println("消去したぜ！");
        panel.remove(StartButton);
        remove(panel);
        System.out.println("消去したぜ！");
        add(panel2,"North");
        panel2.add(NextButton);
        System.out.println("追加したぜ！");
        */
        panel2.setVisible(true);
    }
    
    ///オーバーライドぉぉ
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource() == AboutButton){
            System.out.println("＼(^o^)／");
            new このソフトウェアについて();      
        }
        
        if(arg0.getSource() == StartButton){
            test();
            System.out.println("＼(^o^)／");
        }
    }
}
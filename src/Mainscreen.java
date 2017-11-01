
import com.github.sarxos.webcam.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import java.awt.image.*;
import javax.imageio.*;

//お絵かき
import java.awt.geom.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harukin
 */

class TopScreen extends GUIConfig {
    
    boolean debug=false;
    
    JTabbedPane tabbedpane = new JTabbedPane();
    Color color;
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
    JPanel third    = new JPanel(),
           third2_1 = new JPanel(),
           third2_2 = new JPanel();
    
    JLabel    Announcetext3  = new JLabel("撮影をします。"),
              thirdlabel     = new JLabel("右のボタンを押して撮影を開始してください。");
    
    JButton   NextButton3 = new JButton("次へ"),
              BackButton3 = new JButton("戻る"),
              Capture     = new JButton("撮影！");
    
    WebcamPanel webpanel;
    Webcam webcam = Webcam.getDefault();
    boolean flag;
    
    
    
    //四段階目のGUI
    JPanel  forth    = new JPanel(),
            forth2_1 = new JPanel(),
            forth2_2 = new JPanel(),
            Drawing_right = new JPanel(),
            Drawing_left  = new JPanel(),
            Drawing_down  = new JPanel(),
            Drawing_down2 = new JPanel();
    
    JLabel  Announcetext4  = new JLabel("お絵かきをします。"),
            forthlabel     = new JLabel("今の色"+color);
    
    JButton NextButton4 = new JButton("次へ"),
            BackButton4 = new JButton("戻る");
    
    BufferedImage image;
    
    JColorChooser CTool = new JColorChooser();
    GPanel p = new GPanel();
    
    
   
    //五段階目のGUI
    JPanel fifth = new JPanel(),
           fifth2_1 = new JPanel(),
           fifth2_2 = new JPanel();
    
    JLabel    Announcetext5  = new JLabel("終了です！！"),
              fifthlabel    = new JLabel();
    
    JButton   NextButton5 = new JButton("トップへ"),
              BackButton5 = new JButton("戻る");
    public TopScreen()throws Exception,InterruptedException{
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
        first2.setLayout(new BorderLayout());
        first2.add(label,"West");
        first2.add(AboutButton,"West");
        AboutButton.addActionListener(this);
        first2.add(StartButton,"East");
        StartButton.addActionListener(this);
        //２枚目
        tabbedpane.addTab("次に",add(second));
        second.setLayout(new BorderLayout());
        second.add(second2_2,"South");
        second2_2.setLayout(new BorderLayout());
        second.add(second2_1);
        second2_1.add(Announcetext2);
        second2_2.setBackground(Color.LIGHT_GRAY);
        second2_2.add(BackButton2,"West");
        BackButton2.addActionListener(this);
        second2_2.add(label);
        second2_2.add(NextButton2,"East");
        NextButton2.addActionListener(this);
        //３枚目
        tabbedpane.addTab("撮影",add(third));
        third.setLayout(new BorderLayout());
        third.add(third2_2,"South");
        third.add(third2_1);
        third2_2.setLayout(new BorderLayout());
        third2_1.add(Announcetext3);
        third2_2.setBackground(Color.LIGHT_GRAY);
        third2_2.add(BackButton3,"West");
        BackButton3.addActionListener(this);
        third2_2.add(label);
        third2_2.add(NextButton3,"East");
        NextButton3.addActionListener(this);
        third2_2.add(Capture,"North");
        Capture.addActionListener(this);
         if(debug==false){
            if(webcam!=null){
                webcam.setViewSize(WebcamResolution.VGA.getSize());
                WebcamPanel webpanel = new WebcamPanel(webcam);
                webpanel.setFPSDisplayed(true);
                webpanel.setDisplayDebugInfo(true);
                webpanel.setImageSizeDisplayed(true);
                webpanel.setMirrored(true);
                third.add(webpanel);
            }
            else{
                flag=true;
                System.out.println("true");
                new Exception2nd();
            }
        }else{
            third.add(new JLabel("デバックにつき無効化"));
            System.out.println("デバッグモードが有効になっています。");
        }
        /*
        写真を取得する処理
        */
        add(new JLabel("写真取得領域"));
        //４枚目
        tabbedpane.addTab("お絵かき",add(forth));
        forth.setLayout(new BorderLayout());
        forth.add(forth2_2,"South");
        forth.add(forth2_1);
        forth.add(Drawing_left,"West");
        Drawing_left.setLayout(new FlowLayout());
        Drawing_left.setBackground(Color.LIGHT_GRAY);
        forth.add(Drawing_right,"East");
        Drawing_right.setLayout(new GridLayout());
        Drawing_right.setBackground(Color.LIGHT_GRAY);
        forth2_2.setLayout(new BorderLayout());
        forth.add(p, BorderLayout.CENTER);
        /*forth2_1.add(Announcetext4);
        forth2_1.add(forthlabel,"North");*/
        forth2_2.setBackground(Color.LIGHT_GRAY);
        forth2_2.add(BackButton4,"West");
        forth2_2.add(Drawing_down,"North");
        BackButton4.addActionListener(this);
        forth2_2.add(label);
        forth2_2.add(NextButton4,"East");
        Drawing_down.setLayout(new BorderLayout());
        Drawing_down.setSize(100,100);
        Drawing_right.add(CTool,"East");
        Drawing_down.add(Drawing_down2,"West");
        CTool.getSelectionModel().addChangeListener(this);
        NextButton4.addActionListener(this);
        //forth.add(new JLabel("絵画領域"));
        
        /*
        絵を描くための処理
        */
        //５枚目
        tabbedpane.addTab("完了",add(fifth));
        fifth.setLayout(new BorderLayout());
        fifth.add(fifth2_2,"South");
        fifth.add(fifth2_1);
        fifth2_2.setLayout(new BorderLayout());
        fifth2_1.add(Announcetext5);
        fifth2_2.setBackground(Color.LIGHT_GRAY);
        fifth2_2.add(BackButton5,"East");
        BackButton5.addActionListener(this);
        fifth2_2.add(label);
        
        fifth2_2.add(NextButton5,"West");
        NextButton5.addActionListener(this);
        
        
        
        
        
        add(tabbedpane);
        if(debug==true||flag==false)setVisible(true);
        
        
        
    } 
    
    ///オーバーライドぉぉ
    @Override
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getSource() == AboutButton) new Informationscreen();
        if(arg0.getSource() == StartButton) tabbedpane.setSelectedIndex(1);
        if(arg0.getSource() == NextButton2) tabbedpane.setSelectedIndex(2);
        if(arg0.getSource() == BackButton2) tabbedpane.setSelectedIndex(0);
        if(arg0.getSource() == NextButton3) tabbedpane.setSelectedIndex(3);
        if(arg0.getSource() == BackButton3) tabbedpane.setSelectedIndex(1);
        if(arg0.getSource() == NextButton4) tabbedpane.setSelectedIndex(4);
        if(arg0.getSource() == BackButton4) tabbedpane.setSelectedIndex(2);
        if(arg0.getSource() == NextButton5) tabbedpane.setSelectedIndex(0);
        if(arg0.getSource() == BackButton5) tabbedpane.setSelectedIndex(3);
        if(arg0.getSource() == Capture){
            Calendar calender = Calendar.getInstance();
            String no = "capture:"+calender.get(Calendar.HOUR_OF_DAY)+":"+calender.get(Calendar.MINUTE)+":"+calender.get(Calendar.SECOND)+".png";
            File select = null;
            image = webcam.getImage();
            if(new File(new File("./").getParent(), "rawpicture").canRead() == false){
                new File(new File("./").getParent(), "rawpicture").mkdir();
            }
            try {
                ImageIO.write(image, "PNG", select = new File("./rawpicture",no));
            } catch (IOException ex) {
                System.err.println("err");
            }
            System.out.println(select.getPath());
            p.img = "./rawpicture/"+no;
            p.a=true;
        }
    }
    @Override
    public void windowClosing(WindowEvent arg0) {
        dispose();
        System.exit(0);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
	p.color = CTool.getColor();
        System.out.println(e+"  "+color);
        //p.repaint();
	//mpc.setColor(color);
    }
    @Override
    public void mouseClicked(MouseEvent e){
        Point point = e.getPoint();
        System.out.println("x:" + point.x + ",y:" + point.y);
        /*p.x1 = p.x2 = e.getX();
        p.y1 = p.y2 = e.getY();
        p.paintComponent(getGraphics());*/
    }
      String img2 = null;
    BufferedImage image2 =null;
    
  
  
}


class GPanel   extends GraphicConfig {
    String img = null;
    BufferedImage image =null;
    int x1=0,y1=0;
    int x2,y2;
    int w = this.getWidth();
    int h = this.getHeight();
    int left = this.getX();
    int top = this.getY();
    int size = 10;
    boolean a=false;
    Color color = new Color(0,0,0,255);
    GPanel(){
        addMouseListener(this);
        addMouseMotionListener(this);
        
    }
  public void paintComponent(Graphics g) {
    //super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    
    try{
        image = ImageIO.read(new File(img));
    }catch(Exception e){
        System.out.println("err");
    }
    if(a==true){
        g2.drawImage(image, this.left, this.top, this);
        a=false;
    }
    //for(int i = 0;i < 10;i++){
      g2.setPaint(color);
      //g2.fill(s);
    //}
      //g2.fill(new Ellipse2D.Int(x1-5,y1-5,x1+5,y1+5));
      //g2.drawOval(x1-5, y1-5, 10, 10);
      //g2.drawRect(x1-5, y1-5, 10, 10);
      g2.drawLine(x1,y1,x2,y2); 
      
      System.out.println("描画しました w="+w+" h="+h+" left="+left+" top="+top);
  }
  public void mousePushed(MouseEvent e){
        Point point = e.getPoint();
        System.out.println("x:" + point.x + ",y:" + point.y);
        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        System.out.println(x1+" "+x2+" "+y1+" "+y2);
        paintComponent(getGraphics());
    }
  public void mouseDragged(MouseEvent e){
        Point point = e.getPoint();
        System.out.println("x:" + point.x + ",y:" + point.y);
        //x1 = x2 = e.getX();
        //y1 = y2 = e.getY();
        x2 = e.getX();
        y2 = e.getY();
        paintComponent(getGraphics());

        x1 = e.getX();    // これが新たな始点になる
        y1 = e.getY();
        System.out.println(x1+" "+x2+" "+y1+" "+y2);
    }
  public void mouseMoved(MouseEvent e){
        x1 = e.getX();    // これが新たな始点になる
        y1 = e.getY();
  }

}
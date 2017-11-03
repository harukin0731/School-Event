
import com.github.sarxos.webcam.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
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
            Drawing_right1 = new JPanel(),
            Drawing_right2 = new JPanel(),
            Drawing_down  = new JPanel(),
            Drawing_down2 = new JPanel();
    
    JLabel  Announcetext4  = new JLabel("お絵かきをします。"),
            forthlabel     = new JLabel("今の色"+color);
    
    JButton NextButton4 = new JButton("次へ"),
            BackButton4 = new JButton("戻る"),
            reset = new JButton("やり直す");
    
    BufferedImage image;
    
    JColorChooser CTool = new JColorChooser();
    Java2dTest p = new Java2dTest();
    JSlider slider = new JSlider();
    JTabbedPane stamp = new JTabbedPane();
    
    
   
    //五段階目のGUI
    JPanel fifth = new JPanel(),
           fifth2_1 = new JPanel(),
           fifth2_2 = new JPanel();
    
    JLabel    Announcetext5  = new JLabel("終了です！！係員を呼んでプリントしてもらいましょう！"),
              fifthlabel    = new JLabel();
    
    JButton   NextButton5 = new JButton("トップへ"),
              BackButton5 = new JButton("戻る"),
              print = new JButton("プリントする");
    ImageIcon   icon22;
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
        forth.add(p,"Center");
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
        //Drawing_right.add(Drawing_right1,"North");
        //Drawing_right.add(Drawing_right2,"South");
        Drawing_right.add(CTool);
        //Drawing_right.add(slider);
        
        Drawing_down.add(Drawing_down2,"West");
        CTool.getSelectionModel().addChangeListener(this);
        NextButton4.addActionListener(this);
        Drawing_down.add(stamp);
        Drawing_left.add(reset);
        reset.addActionListener(this);
        Stamplist();
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
        Announcetext5.setIcon(icon22);
        fifth2_1.add(Announcetext5);
        fifth2_2.setBackground(Color.LIGHT_GRAY);
        fifth2_2.add(BackButton5,"East");
        //fifth.add(print,"Center");
        BackButton5.addActionListener(this);
        print.addActionListener(this);
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
        if(arg0.getSource() == NextButton4) {
            tabbedpane.setSelectedIndex(4);
            System.out.println("次へのボタンが押された！");
            p.expo=p.makeImage(p.bufferImage);//イメージの作成
            System.out.println("画像が作成された！");
            p.saveImage(p.expo, "outtest.png", "png");//保存
            System.out.println("保存された！");
            icon22 = new ImageIcon(p.img);
        }
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
        if(arg0.getSource() == stam1){
            p.pentype = "stam1";
            p.stmps = test1_label;
        }
        if(arg0.getSource() == stam2){
            p.pentype = "stam2";
            p.stmps = test2_label;
        }
        if(arg0.getSource() == atu1){
            p.pentype = "atu1";
            p.stmps = atumori_label1;
        }
        if(arg0.getSource() == atu2){
            p.pentype = "atu2";
            p.stmps = atumori_label2;
        }
        if(arg0.getSource() == atu3){
            p.pentype = "atu3";
            p.stmps = atumori_label3;
        }
        if(arg0.getSource() == atu4){
            p.pentype = "atu4";
            p.stmps = atumori_label4;
        }
        if(arg0.getSource() == atu5){
            p.pentype = "atu5";
            p.stmps = atumori_label5;
        }
        if(arg0.getSource() == atu6){
            p.pentype = "atu6";
            p.stmps = atumori_label6;
        }
        if(arg0.getSource() == atu7){
            p.pentype = "atu7";
            p.stmps = atumori_label7;
        }
        if(arg0.getSource() == atu8){
            p.pentype = "atu8";
            p.stmps = atumori_label8;
        }
        if(arg0.getSource() == reset){
            p.a=true;
            p.paint(p.getGraphics());
        }
         if(arg0.getSource() == atamanowaruihito){
            p.pentype = "atamanowaruihito";
            p.stmps = atamano;
        }
         if(arg0.getSource() == nscool){
            p.pentype = "newschool";
            p.stmps = newschool_label;
        }
        if(arg0.getSource() == atu0){
            p.pentype = "atu0";
            p.stmps = atumori_label0;
        }
        if(arg0.getSource() == atu_){
            p.pentype = "atu_";
            p.stmps = atumori_label_;
        }
         if(arg0.getSource() == atamanowaruihito){
            p.pentype = "atamanowaruihito";
            p.stmps = atamano;
        }
        if(arg0.getSource() == print)p.printAll(p.g3);
    }
    @Override
    public void windowClosing(WindowEvent arg0) {
        dispose();
        System.exit(0);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
	p.color = CTool.getColor();
        p.pentype = "pen";
        System.out.println(e+"  "+color);
        //p.repaint();
	//mpc.setColor(color);
    }
    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println(e);
        Point point = e.getPoint();
        System.out.println("x:" + point.x + ",y:" + point.y);
        /*p.x1 = p.x2 = e.getX();
        p.y1 = p.y2 = e.getY();
        p.paintComponent(getGraphics());*/
    }
    
    JPanel  stamps1 = new JPanel(),
            stamps2 = new JPanel(),
            stamps3 = new JPanel();

    String test1_label = "./Stamp/百錬鉄.png",
           test2_label = "./Stamp/百錬館看板.png",
           atumori_label_ = "./Stamp/Twitter/matsukou.png",
           atumori_label0 = "./Stamp/Twitter/atsumori.png",
           atumori_label1 = "./Stamp/Twitter/denki.png",
           atumori_label2 = "./Stamp/Twitter/densi.png",
           atumori_label3 = "./Stamp/Twitter/doboku.png",
           atumori_label4 = "./Stamp/Twitter/joho.png",
           atumori_label5 = "./Stamp/Twitter/kenchiku.png",
           atumori_label6 = "./Stamp/Twitter/kikai.png",
           atumori_label7 = "./Stamp/Twitter/kouka.png",
           atumori_label8 = "./Stamp/Twitter/seni.png",
            atamano = "./Stamp/Twitter/atamanowaruihito.png",
            newschool_label = "./Stamp/新校舎.png";
    ImageIcon test1 = new ImageIcon(test1_label),
            test2 = new ImageIcon(test2_label),
            atumori_ = new ImageIcon(atumori_label_),
            atumori0 = new ImageIcon(atumori_label0),
            atumori1 = new ImageIcon(atumori_label1),
            atumori2 = new ImageIcon(atumori_label2),
            atumori3 = new ImageIcon(atumori_label3),
            atumori4 = new ImageIcon(atumori_label4),
            atumori5 = new ImageIcon(atumori_label5),
            atumori6 = new ImageIcon(atumori_label6),
            atumori7 = new ImageIcon(atumori_label7),
            atumori8 = new ImageIcon(atumori_label8),
            atama = new ImageIcon(atamano),
            newscool = new ImageIcon(newschool_label);
    
    JLabel test1_1 = new JLabel(test1),
           test2_1 = new JLabel(test2),
           atumori__1 = new JLabel(atumori_),
           atumori0_1 = new JLabel(atumori0),
           atumori1_1 = new JLabel(atumori1),
           atumori2_1 = new JLabel(atumori2),
           atumori3_1 = new JLabel(atumori3),
           atumori4_1 = new JLabel(atumori4),
           atumori5_1 = new JLabel(atumori5),
           atumori6_1 = new JLabel(atumori6),
           atumori7_1 = new JLabel(atumori7),
           atumori8_1 = new JLabel(atumori8),
           atama_1 = new JLabel(atama),
           newschool = new JLabel(newscool);
            
    JButton stam1 = new JButton(),
            stam2 = new JButton(),
            atu_ = new JButton(),
            atu0 = new JButton(),
            atu1 = new JButton(),
            atu2 = new JButton(),
            atu3 = new JButton(),
            atu4 = new JButton(),
            atu5 = new JButton(),
            atu6 = new JButton(),
            atu7 = new JButton(),
            atu8 = new JButton(),
            atamanowaruihito = new JButton(),
            nscool = new JButton();
    
    void Stamplist(){
        stam1.setIcon(test1);
        stam1.setSize(100, 100);
        stamps1.setLayout(new GridLayout(1,5));
        stamps1.add(stam1);
        stamps1.add(stam2);
        stamps2.add(atamanowaruihito);
        stamps1.add(nscool);
        stamps1.add(atu_);
        stamp.addTab("松工",add(stamps1));
        stam1.addActionListener(this);
        stam1.addMouseListener(this);
        stam1.addMouseMotionListener(this);
        stam2.setIcon(test2);
        stam2.setSize(100, 100);
        atamanowaruihito.addActionListener(this);
        atamanowaruihito.addMouseListener(this);
        atamanowaruihito.addMouseMotionListener(this);
        atamanowaruihito.setIcon(atama);
        nscool.addActionListener(this);
        nscool.addMouseListener(this);
        nscool.addMouseMotionListener(this);
        nscool.setIcon(newscool);
        atu_.addActionListener(this);
        atu_.addMouseListener(this);
        atu_.addMouseMotionListener(this);
        atu_.setIcon(atumori_);
        stamp.addTab("Twitter",add(stamps2));
        stamps2.setLayout(new GridLayout(1,5));
        stam2.addActionListener(this);
        stam2.addMouseListener(this);
        stam2.addMouseMotionListener(this);
        stamp.addTab("学科マーク",add(stamps3));
        stamps3.setLayout(new GridLayout(1,8));
        atu0.setIcon(atumori0);
        atu1.setIcon(atumori1);
        atu2.setIcon(atumori2);
        atu3.setIcon(atumori3);
        atu4.setIcon(atumori4);
        atu5.setIcon(atumori5);
        atu6.setIcon(atumori6);
        atu7.setIcon(atumori7);
        atu8.setIcon(atumori8);
        atu0.setSize(100, 100);
        atu1.setSize(100, 100);
        atu2.setSize(100, 100);
        atu3.setSize(100, 100);
        atu4.setSize(100, 100);
        atu5.setSize(100, 100);
        atu6.setSize(100, 100);
        atu7.setSize(100, 100);
        atu8.setSize(100, 100);
        stamps2.add(atu0);
        stamps3.add(atu1);
        stamps3.add(atu2);
        stamps3.add(atu3);
        stamps3.add(atu4);
        stamps3.add(atu5);
        stamps3.add(atu6);
        stamps3.add(atu7);
        stamps3.add(atu8);
        atu0.addActionListener(this);
        atu1.addActionListener(this);
        atu2.addActionListener(this);
        atu3.addActionListener(this);
        atu4.addActionListener(this);
        atu5.addActionListener(this);
        atu6.addActionListener(this);
        atu7.addActionListener(this);
        atu8.addActionListener(this);
    }
      String img2 = null;
    BufferedImage image2 =null;
  
  
}



class Java2dTest extends GraphicConfig{
    Java2dTest(){
        addMouseListener(this);
        addMouseMotionListener(this);
        /*Java2dTest test = new Java2dTest();
        
        addWindowListener(this);
        
        test.setBounds( 0, 0, 200, 200);
        test.setVisible(true);*/
    }
    
    BufferedImage readImage = null;
    String picturepass = null;
    String pentype = "pen";
    String stmps = null;
    String img;
    Graphics2D g2,g3;
    int x1=0,y1=0;
    int x2,y2;
    int w = this.getWidth();
    int basex;
    int basey;
    int h = this.getHeight();
    int left = this.getX();
    int top = this.getY();
    int size = 10;
    boolean a=false;
    Color color = new Color(0,0,0,255);
    
    BufferedImage   image = null,
                    stmp  = null,
                    expo  = null,
                    bufferImage;
    
    public void paint(Graphics g){
        g2 = (Graphics2D)g;

        if(a==true){
            try{
                image = ImageIO.read(new File(img));
                basey = image.getHeight();
                basex = image.getWidth();
            }catch(Exception e){
                System.out.println("err");
            }
            if (image == null){
                image = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_BGR);
            }
            g3=image.createGraphics();
            g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g3.drawImage(image, this.left, this.top, this);
            a=false;
        }
        g3.setPaint(color);
        if(pentype=="pen"){
            g3.fillOval(x1-5, y1-5, 10, 10);
            g3.fillOval(x1-5, y1-5, 10, 10);
        }
        else{
            try{
                stmp = ImageIO.read(new File(stmps));
                y2=y1-(stmp.getHeight()/2);
                x2=x1-(stmp.getWidth()/2);
                System.out.println("スタンプ");
            }catch(Exception e){
                System.out.println("err");
            }
            g3.drawImage(stmp, x2, y2, this);
        }
        System.out.println("描画しました w="+w+" h="+h+" left="+left+" top="+top);
        if (image != null){
            g2.drawImage(image, 0, 0, this);
        }
        try {
            boolean result = ImageIO.write(image, "png", new File("sample2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*public void mousePushed(MouseEvent e){
    Point point = e.getPoint();
    System.out.println("x:" + point.x + ",y:" + point.y);
    x1 = x2 = e.getX();
    y1 = y2 = e.getY();
    System.out.println(x1+" "+x2+" "+y1+" "+y2);
    paint(getGraphics());
    }*/
    
    public void mouseDragged(MouseEvent e){
        //x1 = x2 = e.getX();
        //y1 = y2 = e.getY();
        /*x2 = e.getX();
        y2 = e.getY();
        paintComponent(getGraphics());*/

        x1 = e.getX();    // これが新たな始点になる
        y1 = e.getY();
        System.out.println(x1+" "+x2+" "+y1+" "+y2);
        paint(getGraphics());
    }
    
    public void mouseMoved(MouseEvent e){
        x1 = e.getX();    // これが新たな始点になる
        y1 = e.getY();
    }
    
    public void mouseClicked(MouseEvent e){
        System.out.println(e);
        Point point = e.getPoint();
        System.out.println("x:" + point.x + ",y:" + point.y);
        x1 = x2 = e.getX();
        y1 = y2 = e.getY();
        paint(getGraphics());
        /*p.x1 = p.x2 = e.getX();
        p.y1 = p.y2 = e.getY();
        p.paintComponent(getGraphics());*/
    }
    
    BufferedImage makeImage(BufferedImage a){
        int x2=getWidth();//画面の幅を取得
        int y2=getHeight();//画面の高さを取得
        int iw=image.getWidth(this);//イメージの幅を取得
        int ih=image.getHeight(this);//イメージの高さを取得
        int x0=0;//画面左位置
        int y0=0;//画面上端位置
        int x1=x2/2;//画面中央位置（横）
        int y1=y2/2;//画面中央位置（縦）
        g2.dispose();//不要になったグラフィクスは廃却
        System.out.println("makeImage実行");
        return a;//作成したイメージを戻り値として返す
    }
    boolean saveImage(BufferedImage image,String fileName,String format){
        try{
            OutputStream out=new FileOutputStream(fileName);//ファイルとアプリを繋ぐ
            ImageIO.write(image, format, out);//指定の形式で出力
            return true;//成功したらtrueを返す。
        }catch(IOException e){
      //例外処理が発生したらエラーをコンソールに出して、falseを返す
            System.out.println("Err="+e);//エラー出力
            return false;//falseを返す
        }
    }
    
    public int print(Graphics g, PageFormat pf, int pNo)throws PrinterException{     
        switch(pNo){
            case 0:		//	１ページ目
                g.drawImage(image, 0, 0, this);
  		break;
            default:		//	それ以外のページ
		return Printable.NO_SUCH_PAGE;   
            }
	return Printable.PAGE_EXISTS;   
	} 
    public void actionPerformed(ActionEvent e){
           
    }
}





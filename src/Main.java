import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Main {

    public static JFrame frame = new JFrame("Land of Tanks Menu");
    public static JButton btn[] = new JButton[2];
    public static JLabel lblmoney;
    public static String selTank="None";
    
    public static ImageIcon ltraktor,tiger, ltlarge, tiglarge;
    
    public static Integer screen=0;
    public static boolean mouseDown;
    public static int mX, mY;
    public static JPanel panel = new JPanel(){
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.clearRect(0, 0, 750, 520);
            g.setColor(Color.black);
            g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
            g.setColor(Color.white);
            g.drawString("Current Tank: "+selTank, 25, 30);
            drawTankBoxes(g);
            repaint();
        }
    };
    public static int money=5000;
    public static int mainJW, mainJH;
    public static int btnW=150, btnH=30;
    
    public static void main(String[] args) {
        frame.setSize(800,600);
        mainJW=frame.getWidth();
        mainJH=frame.getHeight();
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mX=e.getX();
                mY=e.getY();
                //System.out.println("X: "+mX + " Y: "+ mY);
            }
        });
        panel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                mouseDown=true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDown=false;
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        init();
        TechTree.init();
        frame.setVisible(true);
        
    }
    public static void show(){
        panel.setVisible(true);
        for(int i=0;i<btn.length;i++)
        {
            btn[i].setVisible(true);
        }
    }
    public static void init(){
        lblmoney = new JLabel();
        lblmoney.setBounds(25, 5, btnW, btnH);
        lblmoney.setText("Money: "+ money);
        frame.add(lblmoney);
        ltraktor = new ImageIcon(Main.class.getResource("/LTraktor.png"));
        tiger = new ImageIcon(Main.class.getResource("/tiger.png"));
        tiglarge = new ImageIcon(Main.class.getResource("/tigerlarge.png"));
        ltlarge = new ImageIcon(Main.class.getResource("/LTraktorlarge.png"));
        
        panel.setBounds(25,40,750,520);
        panel.setVisible(true);
        frame.add(panel);
        
        btn[0] = new JButton();
        btn[0].setText("Play");
        btn[0].setBounds(300,5,btnW,btnH);
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoTGame.show();
                screen =1;
                for(int i=0;i<btn.length;i++)
                {
                    btn[i].setVisible(false);
                    lblmoney.setVisible(false);
                    panel.setVisible(false);
                    
                }
            }
        });
        btn[0].setVisible(true);
        frame.add(btn[0]);
        
        btn[1] = new JButton();
        btn[1].setText("TechTree");
        btn[1].setBounds(475+btnW,5,btnW,btnH);
        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TechTree.show();
                screen =2;
                for(int i=0;i<btn.length;i++)
                {
                    btn[i].setVisible(false);
                    panel.setVisible(false);
                }
                
            }
        });
        btn[1].setVisible(true);
        frame.add(btn[1]);
    }
    private static void drawTankBoxes(Graphics g){
        //checks to see what tank is selected
        if(mX>18&& mX<ltraktor.getIconWidth()+18&&mY>420 && mY<ltraktor.getIconHeight()+420){
            if(mouseDown==true){
                selTank="LTraktor";
            }
        }
        else if(mX>140&& mX<tiger.getIconWidth()+140&&mY>430 && mY<tiger.getIconHeight()+430){
            if(mouseDown==true){
                selTank="Tiger";
            }
        }
        
        //draws white boxes for tanks in garage
        for (int i = 0; i < 6; i++) {
                g.setColor(Color.white);
                g.fillRect(17+(123*i),400,100,100);
        }
        //draws tanks into the garage
        
        //sets tank display to current tank
        if(selTank.equals("LTraktor")){
            g.drawImage(ltlarge.getImage(), 18, 100, null);
            g.setColor(Color.yellow);
            g.fillRect(17,400,100,100);
        }
        else if(selTank.equals("Tiger")){
            g.drawImage(tiglarge.getImage(), 18, 100, null);
            g.setColor(Color.yellow);
            g.fillRect(140,400,100,100);
        }
        g.drawImage(ltraktor.getImage(), 18, 420, null);
        g.drawImage(tiger.getImage(), 140, 430, null);
    }
    
}

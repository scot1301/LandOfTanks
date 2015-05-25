import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TechTree extends Main{
    private static JButton mainMenu;
    private static JPanel techpanel = new JPanel(){
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.clearRect(0, 0, 750, 520);
            g.setColor(Color.black);
            g.fillRect(0, 0, techpanel.getWidth(), techpanel.getHeight());
            g.setColor(Color.white);
            g.drawString("USSR Tanks:", 25, 50);
            g.drawString("British Tanks:", 25, 160);
            g.drawString("German Tanks:", 25, 270);
            g.drawString("American Tanks:", 25, 380);
            for(int x=0; x<5;x++){
                g.drawString("Tier "+(x+1),(x*130)+140, 30);
            }
            repaint();
        }
    };
    public static void init(){
        techpanel.setBounds(25,40,750,520);
        techpanel.setVisible(false);
        frame.add(techpanel);
        mainMenu = new JButton();
        mainMenu.setBounds(25,5,btnW,btnH);
        mainMenu.setText("Back");
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.show();
                hide();
            }
        });
        mainMenu.setVisible(false);
        frame.add(mainMenu);
    }
    public static void show(){
        lblmoney.setVisible(true);
        lblmoney.setBounds(200, 5, 150, 30);
        techpanel.setVisible(true);
        mainMenu.setVisible(true);
        
        
        
        
        
        
    }
    public static void hide(){
        mainMenu.setVisible(false);
        techpanel.setVisible(false);
        lblmoney.setBounds(25, 5, btnW, btnH);
        
    }
    
}


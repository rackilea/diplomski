import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class displayFullScreen extends JFrame { 
        private JLabel alarmMessage = new JLabel("Alarm !");
        private JPanel panel = new JPanel();
        public displayFullScreen() {
            setUndecorated(true);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            alarmMessage.setText("Alarm !");
            alarmMessage.setFont(new Font("Cambria",Font.BOLD,100));
            alarmMessage.setForeground(Color.CYAN);
            panel.add(alarmMessage);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setBounds(0,0,screenSize.width,screenSize.height);
            panel.setBackground(Color.black);
            add(panel);

            addKeyListener(new KeyAdapter() {
               public void keyPressed(KeyEvent ke) {
                   escapeHandler(ke);
               } 
            });
        }

        public void escapeHandler(KeyEvent ke) {
            if(ke.getKeyCode() == ke.VK_ESCAPE) {
                displayFullScreen.this.dispose();
            } 
        }
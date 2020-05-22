import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class HelloWorldApplet extends javax.swing.JApplet {

    String greeting;

    Font myFont = new Font("Times New Roman", Font.BOLD, 20);

    public void init() {

        greeting = "Hello World";

        add(new MyPanel());

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                repaint();

            }       
        };

        Timer timer = new Timer(500, actionListener);
        timer.start();


    }

    class MyPanel extends JPanel {

        public void paintComponent(Graphics screen) {

            super.paintComponent(screen);

            Calendar now = Calendar.getInstance();
            int second = now.get(Calendar.SECOND);
            int hour = now.get(Calendar.HOUR_OF_DAY);
            int minute = now.get(Calendar.MINUTE);
            int month = now.get(Calendar.MONTH) + 1;
            int day = now.get(Calendar.DAY_OF_MONTH);
            int year = now.get(Calendar.YEAR);

            String currentTime = ("The time currently is: " + hour + ":" + minute
                    + " and " + second + " seconds");
            String currentDate = ("Date: " + month + "/" + day + "/" + year);

            setFont(myFont);

            Graphics2D screen2D = (Graphics2D) screen;
            screen2D.drawString(greeting, 20, 50);
            screen2D.drawString(currentTime, 20, 75);
            screen2D.drawString(currentDate, 20, 100);

        }

    }


}
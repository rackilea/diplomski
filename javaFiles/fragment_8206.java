import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Draw extends JPanel implements ActionListener {
private Color topColorTraffic = Color.red;
private Color middleColorTraffic = Color.gray;
private Color bottomColorTraffic = Color.gray;

private Color topColorPeds = Color.gray;
private Color bottomColorPeds = Color.green;

// WE INITIALIZED THE UPPER VARIABLE LIKE THIS BECAUSE WE PRESUMED THAT
// IS RED FOR THE CARS AND GREEN FOR THE PEDS

private long startTime; // This will get the time when we've started the "animation"

private long targetTimeTraffic; // This will be the time we want the have
                                // between red changes to
                                // yellow in the traffic
private long targetTimeYellowLight; //This will be the time we want the yellow
                                    //light to be displayed
private Timer t;

public Draw() {
    startTime = System.currentTimeMillis();
    targetTimeTraffic = 3000; // 3 sec
    targetTimeYellowLight = 1200; //1.2 sec
    t = new Timer(5, this); // this will call actionPerformed every 5 miliseconds
    t.start();
}


public void paintComponent(Graphics back) {
    super.paintComponent(back);

    back.setColor(Color.black);
    back.fillRect(30, 30, 330, 900); // make traffic light for car
    back.fillRect(440, 140, 330, 720); // make traffic light for peds

    back.setColor(topColorTraffic); // creates the top traffic circle
    back.fillOval(45, 45, 300, 280);
    back.setColor(topColorPeds); // creates the top peds circle
    back.fillOval(455, 155, 300, 280);

    back.setColor(middleColorTraffic); // creates the middle traffic circle
    back.fillOval(45, 335, 300, 280);

    back.setColor(bottomColorTraffic); // creates the bottom traffic circle
    back.fillOval(45, 625, 300, 280);
    back.setColor(bottomColorPeds); // creates the bottom peds circle
    back.fillOval(455, 555, 300, 280);
}

public void actionPerformed(ActionEvent arg0) {
    // changing from red to yellow in traffic
    long currentTime = System.currentTimeMillis();
    if (targetTimeTraffic <= currentTime - startTime) { //1st delay 3 sec
        topColorTraffic = Color.gray;
        middleColorTraffic = Color.yellow;
        topColorPeds = Color.red;
        bottomColorPeds = Color.gray;
    }

    //changing from yellow to green
    if (targetTimeTraffic <= currentTime - startTime - targetTimeYellowLight) { //2nd delay 3 sec + another 1.2 sec
                                                                                //but 3 sec were already for the 1st delay
                                                                                // so we get only 1.2 sec delay
        topColorTraffic = Color.gray;
        middleColorTraffic = Color.yellow;
        bottomColorTraffic = Color.green;
        middleColorTraffic = Color.gray;
        //startTime = System.currentTimeMillis();
    }

    //changing from green to yellow
    if (targetTimeTraffic <= currentTime - startTime - targetTimeYellowLight - targetTimeTraffic) { 
        topColorTraffic = Color.gray;
        bottomColorTraffic = Color.gray;
        middleColorTraffic = Color.yellow;
    }

    //changing from yellow to red
    if (targetTimeTraffic <= currentTime - startTime - 2* targetTimeYellowLight - targetTimeTraffic) {
        topColorTraffic = Color.red;
        middleColorTraffic = Color.gray;
        topColorPeds = Color.gray;
        bottomColorPeds = Color.green;
        startTime = System.currentTimeMillis(); //reinitialize the variable
    }

    repaint();
    }
}
/*FullScreen01.java
This is a skeleton program that implements the
Full-Screen Exclusive Mode

The program places an undecorated non-resizable JFrame
object on the screen in the Full-Screen Exclusive Mode.

A JButton appears in the North location of the JFrame.
Clicking the button causes the program to exit the full-
screen mode, restore the original graphics mode, and
terminate.

The program places red, green, and white JLabels in the
East, West, South, and Center locations solely to
demonstrate that the graphics object is an undecorated
non-resizable JFrame object.

The program displays a list of the available graphics
devices solely for information purposes in the command-
line window.  However, that window is hidden behind the
full-screen version of the JFrame object and isn't visible
until the full-screen mode is terminated.

Even though the program displays a list of all of the
graphics devices, it operates only on the first graphics
device in the list.

Tested using J2SE5.0 under WinXP.  J2SE 1.4 or later is
required for the setFullScreenWindow method of the
GraphicsDevice object.
**********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FullScreen01 extends JFrame
                                 implements ActionListener{

  private GraphicsDevice graphicsDevice;
  private DisplayMode origDisplayMode;
  private JButton exitButton = new JButton(
                                  "Exit Full-Screen Mode");

  public static void main(String[] args){
    //Get and display a list of graphics devices solely for
    // information purposes.
    GraphicsEnvironment graphicsEnvironment =
         GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] devices = 
                    graphicsEnvironment.getScreenDevices();
    for(int cnt = 0;cnt < 1;cnt++){
      System.out.println(devices[cnt]);
    }//end for loop

    //Construct a full-screen object using
    // graphicsDevice 0.
    new FullScreen01(devices[0]);
  }//end main

  //Constructor
  public FullScreen01(GraphicsDevice graphicsDevice){
    //Save a reference to the graphics device as an
    // instance variable so that it can be used later to
    // exit the full-screen mode.
    this.graphicsDevice = graphicsDevice;

    setTitle("This title will be hidden (undecorated)");

    //Get and save a reference to the original display
    // mode as an instance variable so that it can be
    // restored later.
    origDisplayMode = graphicsDevice.getDisplayMode();

    //Register an action listener on the exitButton.
    exitButton.addActionListener(this);

    //Place the exitButton in the JFrame
    getContentPane().add(exitButton, BorderLayout.NORTH);

    //Place four labels in the JFrame solely for the
    // purpose of showing that it is a full-screen
    // undecorated JFrame.
    JLabel eastLabel = new JLabel("     East     ");
    eastLabel.setOpaque(true);
    eastLabel.setBackground(Color.RED);
    getContentPane().add(eastLabel,BorderLayout.EAST);

    JLabel southLabel =
                 new JLabel("South",SwingConstants.CENTER);
    southLabel.setOpaque(true);
    southLabel.setBackground(Color.GREEN);
    getContentPane().add(southLabel,BorderLayout.SOUTH);

    JLabel westLabel = new JLabel("     West     ");
    westLabel.setOpaque(true);
    westLabel.setBackground(Color.RED);
    getContentPane().add(westLabel,BorderLayout.WEST);

    JTextArea textArea = new JTextArea(20, 30);
    textArea.setText("I'm a JTextArea");
    textArea.setLineWrap(true);
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    getContentPane().add(scrollPane,BorderLayout.CENTER);

    if (graphicsDevice.isFullScreenSupported()){
      // Enter full-screen mode witn an undecorated,
      // non-resizable JFrame object.
      setUndecorated(true);
      setResizable(false);
      //Make it happen!
      graphicsDevice.setFullScreenWindow(this);
      validate();
    }else{
      System.out.println("Full-screen mode not supported");
    }//end else

  }//end constructor

  //The following method is invoked when the used clicks
  // the exitButton
  public void actionPerformed(ActionEvent evt){
    //Restore the original display mode
    graphicsDevice.setDisplayMode(origDisplayMode);
    //Terminate the program
    System.exit(0);
  }//end actionPerformed
}//end classListing 26
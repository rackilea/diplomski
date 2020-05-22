import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class KeyListnerExample extends JFrame implements KeyListener{
    JTextField KeyCodeT;

    public KeyListnerExample(){
        JPanel panel = new JPanel();
        KeyCodeT = new JTextField();
        KeyCodeT.setOpaque(false);
        panel.setLayout(new GridLayout(1,1));
        panel.add(KeyCodeT);
        JOptionPane.showOptionDialog(null, panel, "Enter Key Code", JOptionPane.CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
      KeyCodeT.addKeyListener(this);//Listens for key inputs in the text field
      KeyCodeT.setEditable(false);//disallow user input into the Text field.
      add(KeyCodeT);//add the text field to the screen
      setSize(300,300);//set the screen size
      setVisible(true);//show the window on screen.     
    }
        //Called when the key is pressed down.
    public void keyPressed(KeyEvent e){
        System.out.println("Key Pressed!!!");

        e.getKeyCode();
        System.out.println("key code is: " +e.getKeyCode());

    }

    //Called when the key is released   
    public void keyReleased(KeyEvent e){
        System.out.println("Key Released!!!");
        KeyCodeT.setText("Key Code:" + e.getKeyCode());//displays the key code in the text box

    }
    //Called when a key is typed
    public void keyTyped(KeyEvent e){


    }

     public static void main(String[] args){
      KeyListnerExample key = new KeyListnerExample();
     }

}
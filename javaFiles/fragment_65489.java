import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TempProject extends JPanel{
    /** Label to update with currently pressed keys */
    JLabel output = new JLabel();

    public TempProject(){
        super();
        setFocusable(true);
        add(output, BorderLayout.CENTER);
        requestFocus();
        addKeyListener(new Keyer());
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setContentPane(new TempProject());    
                frame.pack();
                frame.setVisible(true);
                new TempProject();
            }
        });
    }

    public class Keyer implements KeyListener{

        /** Stores currently pressed keys */
        HashSet<Integer> pressedKeys = new HashSet<Integer>();

        public Keyer(){

            //Check every 100ms if there's keys pressed
            //(This is the Swing Timer they talk about)
            new Timer(100, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    String keysString = "";
                    if(!pressedKeys.isEmpty()){
                        Iterator<Integer> i = pressedKeys.iterator();
                        while(i.hasNext()){
                            keysString += i.next() + ",";
                        }
                    } 
                    output.setText(keysString);
                }
            }).start();
        }

        @Override
        public void keyPressed(KeyEvent ovent){
            //Add key to hashSet when pressed
            int keyCode = ovent.getKeyCode();
            pressedKeys.add(keyCode);
        }
        @Override
        public void keyReleased(KeyEvent ovent){
            //Remove key from hashset when released
            int keyCode = ovent.getKeyCode();
            pressedKeys.remove(keyCode);
        }
        @Override
        public void keyTyped(KeyEvent ovent){}
    }



}
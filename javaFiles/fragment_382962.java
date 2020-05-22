import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

// removed implements ActionListener
public class StudentGUI extends JFrame {
    public StudentGUI() {
        super("StudentGUI Frame");

        //TopPanel
        TopPanel tp;
        tp=new TopPanel();
        Dimension d = new Dimension(800,600);
        tp.setPreferredSize(d);
        this.add (tp, BorderLayout.NORTH);
        tp.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        setBackground(Color.PINK);
        tp.setVisible(true);
        //TopPanel End

        //BottomPanel
        BottomPanel bp;
        bp=new BottomPanel();
        this.add (bp, BorderLayout.SOUTH);
        tp.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        //BottomPanel End

        //MiddlePanel 
        MiddlePanel mp;
        mp=new MiddlePanel();
        this.add (mp, BorderLayout.CENTER);
        mp.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        //MiddlePanel End

        this.setVisible(true);

        /* moved action listener within method, 
         * used bp.exitBtn instead of exitBtn
         */
        bp.exitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    int selectedOption =
                        JOptionPane.showConfirmDialog(null, 
                                                      "Do you want to close the window?", 
                                                      "Choose", 
                                                      JOptionPane.YES_NO_OPTION); 
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        System.exit(1);
                    }
                }
            }); // fixed braces, the closing paren should go here

    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}
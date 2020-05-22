package sample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

class P extends JPanel {
    static P g = new P();
    int x = 500;
    int y = 500;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(x, y);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

public class MyFrame extends javax.swing.JFrame {
    public MyFrame() { }
    static void frame(JFrame f) {
        JFrame frame = f;
        int frameWidth = 500;
        int frameHeight = 500;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {

        // 1. creating the frame window
        //
        MyFrame myFrame = new MyFrame();
        myFrame.add( P.g );
        P.g.setLayout( null );

        // others usefull  operations
        // configuring others objetcs
        // to be added on P.g

        // text[0] = new JTextArea(0, 0);
        // text[0].setLineWrap(true);
        // text[0].setEditable(false);
        // JScrollPane scroll = new JScrollPane(text[0]);
        // P.g.add(scroll);

        // 2. setting preferred size
        Dimension preferredSize = P.g.getPreferredSize();
        myFrame.setPreferredSize(preferredSize);

        // 3. need apply the pack method (here or any other place)
        // calling your method frame(JFrame)
        frame(myFrame);

        myFrame.setVisible( true );
        myFrame.pack();   
    }             
}
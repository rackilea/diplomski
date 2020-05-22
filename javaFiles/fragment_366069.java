import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Mouse extends Frame implements MouseListener{
    Mouse(){} // Empty constructor.

    public static void main(String[] args){
        // The frame for the program, you can add onto it.
        JFrame frame = new JFrame("MouseListener");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Mouse mou = new Mouse();
        frame.addMouseListener(mou);
    }

    // All different events you can use!
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {} 
    public void mouseClicked(MouseEvent e) {} 
}
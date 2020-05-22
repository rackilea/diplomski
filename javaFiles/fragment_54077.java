import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyTextArea extends JTextArea implements MouseListener {

   private Image myImage;

   public MyTextArea() {
      addMouseListener(this);
   }

   public void addImage(Image image) {
      this.myImage = image;
      invalidate();
      repaint();
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(myImage, 0, 0, this);
   }

   public static void main(String[] args) {
      JFrame f = new JFrame("Test");
      MyTextArea txt = new MyTextArea();
      f.getContentPane().add(txt);
      f.getContentPane().add(new JButton("Just another component to click on"), BorderLayout.SOUTH);
      f.pack();
      f.setVisible(true);

   }

   @Override
   public void mouseClicked(MouseEvent e) {
      ImageIcon img = new ImageIcon("twitter.png"); //place a png image in your working directory for testing
      addImage(img.getImage());

   }

   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub

   }

}
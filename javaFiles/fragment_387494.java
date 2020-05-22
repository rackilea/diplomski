import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleMouseListenerEg extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private JPanel listenedToPanel = new JPanel();
   private JTextArea textArea = new JTextArea(10, 25);

   public SimpleMouseListenerEg() {
      listenedToPanel.setBorder(BorderFactory.createTitledBorder("Listened To Panel"));
      MouseAdapter myMouseAdapter = new MyMouseAdapter();
      listenedToPanel.addMouseListener(myMouseAdapter);
      listenedToPanel.addMouseMotionListener(myMouseAdapter);

      textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      setLayout(new BorderLayout());
      add(listenedToPanel, BorderLayout.CENTER);
      add(scrollPane, BorderLayout.EAST);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   // a combination MouseListener and MouseMotionListener
   private class MyMouseAdapter extends MouseAdapter {
      private String template = "%-10s [%03d, %03d]%n";

      @Override
      public void mousePressed(MouseEvent mEvt) {
         String text = String.format(template, "Pressed", mEvt.getX(), mEvt.getY());
         textArea.append(text);
      }

      @Override
      public void mouseReleased(MouseEvent mEvt) {
         String text = String.format(template, "Released", mEvt.getX(), mEvt.getY());
         textArea.append(text);
      }

      @Override
      public void mouseDragged(MouseEvent mEvt) {
         String text = String.format(template, "Dragged", mEvt.getX(), mEvt.getY());
         textArea.append(text);
      }
   }

   private static void createAndShowGui() {
      SimpleMouseListenerEg mainPanel = new SimpleMouseListenerEg();

      JFrame frame = new JFrame("SimpleMouseListenerEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
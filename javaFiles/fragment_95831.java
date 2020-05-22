import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import net.imagej.ImageJ;

public class IJDispose {

  public static void main(final String... args) {
    final ImageJ ij = new ImageJ();
    ij.ui().showUI();

    final JFrame frame = new JFrame("Hello");
    final JButton b = new JButton("Close ImageJ");
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        ij.getContext().dispose();
      }
    });
    frame.getContentPane().add(b);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}
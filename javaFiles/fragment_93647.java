import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderEg {
   public static void main(String[] args) {
      int start = 8990;
      int end = 9000;
      int value = 8995;

      final JSlider slider = new JSlider(start, end, value);
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(2);
      slider.setMinorTickSpacing(1);
      Dictionary<Integer, JLabel> labels = new Hashtable<>();
      for (int i = start; i <= end; i += 2) {
         String text = String.format("%4.3f", i / 1000.0);
         labels.put(i, new JLabel(text));
      }

      slider.setLabelTable(labels);
      JPanel panel = new JPanel(new BorderLayout());
      panel.setPreferredSize(new Dimension(400, 50));
      panel.add(slider, BorderLayout.PAGE_START);

      slider.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent e) {
            int value = slider.getValue();
            double sliderValue = value / 1000.0;
            System.out.printf("Slider Value: %4.3f%n", sliderValue);
         }
      });
      JOptionPane.showMessageDialog(null, panel);
   }
}
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DynamicCheckBox extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JPanel north;
    private JPanel center;

    public DynamicCheckBox() {
        north = new JPanel();
        JButton first = new JButton("First");
        JButton second = new JButton("Second");
        north.add(first);
        north.add(second);
        center = new JPanel();
        center.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        first.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                center.removeAll();
                Checkbox[] box = createCheckBox(new String[]{"1", "2"});
                for (int i = 0; i < box.length; i++) {
                    center.add(box[i]);
                }
                center.repaint();
                DynamicCheckBox.this.revalidate();
            }

        });
        second.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                center.removeAll();
                Checkbox[] box = createCheckBox(new String[]{"3", "4"});
                for (int i = 0; i < box.length; i++) {
                    center.add(box[i]);
                }
                center.repaint();
                DynamicCheckBox.this.revalidate();
            }

        });
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.setSize(new Dimension(300, 300));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DynamicCheckBox();
    }

    public Checkbox[] createCheckBox(String[] values) {
         Checkbox[] box = new Checkbox[values.length];
         for (int i = 0; i < values.length; i++) {
             box[i] = new Checkbox(values[i]);
         }
         return box;
    }
}
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends javax.swing.JFrame {

    JSlider slider;

    public MyFrame() {
        // Create the menu
        JMenuBar topMenu = new JMenuBar();
        this.setJMenuBar(topMenu);

        //create the menu button "shapes"
        JMenu shapes = new JMenu("Shapes");
        topMenu.add(shapes);
        //Create the 3 shapes for the menu
        JMenuItem square = new JMenuItem("Square");
        square.addActionListener(new ShapeAction());

        JMenuItem circle = new JMenuItem("Circle");      
        circle.addActionListener(new ShapeAction());

        JMenuItem triangle = new JMenuItem("Triangle");
        triangle.addActionListener(new ShapeAction());

        //add shapes to menu
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(square);

        //add the menu
        setJMenuBar(topMenu);


        MyControlPanel pane = new MyControlPanel();
        getContentPane().add(pane);

        this.add(pane);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // <snip>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                new MyFrame().setVisible(true);
                }
                });
}
        class ShapeAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JMenuItem clickedMenu = (JMenuItem)e.getSource();
                if (clickedMenu.getText().equals("Circle")){ 
                    int value = slider.getValue();
                    MyShape ACircle = new ACircle(value);
                }
            }          
        }

        public class MyControlPanel extends javax.swing.JPanel {

            JLabel sliderLabel;
            JLabel sliderdimension;
            JLabel blank;
            JLabel dl;
            JLabel area1;
            JTextField boundary_length = new JTextField("Boundary Length");
            JTextField area = new JTextField("Area");

            public MyControlPanel() {
                slider = new JSlider();
                slider.setValue(50);
                slider.addChangeListener(new MyChangeAction());
                slider.setMajorTickSpacing(10);
                slider.setPaintLabels(true);
                slider.setPaintTicks(true);
                slider.setBounds(300, 50, 100, 50);

                sliderLabel = new JLabel("50");
                blank = new JLabel("     ");
                sliderdimension = new JLabel("Shape Dimension:");

                dl = new JLabel("Boundary Length =");
                area1 = new JLabel("Area =");

                setLayout(new BorderLayout());

                JPanel sliderPanel = new JPanel();
                sliderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
                sliderPanel.add(sliderdimension);
                sliderPanel.add(sliderLabel);
                sliderPanel.add(slider);
                sliderPanel.add(dl);
                sliderPanel.add(boundary_length);
                sliderPanel.add(area1);
                sliderPanel.add(area);
                this.add(sliderPanel, BorderLayout.PAGE_END);
            }

            public class MyChangeAction implements ChangeListener {
                public void stateChanged(ChangeEvent ce) {
                    int value = slider.getValue();
                    String str = Integer.toString(value);
                    sliderLabel.setText(str);
                    boundary_length.setText(str);
                    area.setText(str);
                }
            }
        }
}
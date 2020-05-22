import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main{

    private JFrame frame;
    JLabel label = new JLabel("LABEL");
    JTextField field = new JTextField(10);

    public void initialWindow(){
        frame = new JFrame("Demo");
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Main mainObj = new Main();
                mainObj.initialWindow();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    class MainPanel extends JPanel{
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        JButton button = new JButton("Submit");
        public MainPanel(){
            setLayout(new BorderLayout());
            setBorder(new EmptyBorder(10, 10, 10, 10));
            add(field, BorderLayout.WEST);
            button.addActionListener(new MyListener());
            add(button, BorderLayout.CENTER);
            add(label, BorderLayout.EAST);
        }
    }

    class MyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            label.setText(field.getText());
        }
    }
}
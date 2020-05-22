import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

        public class JFrameDemo extends JFrame{
        private JButton clearButton;
        private JLabel display = new JLabel();
        private JButton exitButton;
        private JButton go;
        private JTextField nameField;
        private JLabel name;

        public JFrameDemo(){
            doEnglish();
        }

        private void doEnglish(){
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);        

            name = new JLabel("Enter Name");
            getContentPane().add(name);
            name.setBounds(5,30,300,30);        
            nameField = new JTextField();
            getContentPane().add(nameField);    
            nameField.setBounds(80,33,150,25);        

            go = new JButton("Go");
            getContentPane().add(go);
            go.setBounds(5, 65, 50, 30);

            getContentPane().add(display);
            display.setBounds(85,110,400,20);                

            go.addActionListener(new ActionListener() {                        
                @Override
                public void actionPerformed(ActionEvent e) {
                    goButtonActionPerformed();
                }
            });
        }

        private void goButtonActionPerformed(){
            String na = nameField.getText();
                    //display = new JLabel();                               
                    display.setText(na);
        }

        public static void main(String args[]){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new JFrameDemo().setVisible(true);
                }
            });
        }
       }
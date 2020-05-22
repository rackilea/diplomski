import java.awt.FlowLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.FocusEvent;
    import java.awt.event.FocusListener;
    import java.io.FileNotFoundException;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JTextField;

    public class FocusAwareWindow extends JFrame implements ActionListener, FocusListener {
        public static void main(String[] args) throws FileNotFoundException {
            FocusAwareWindow c = new FocusAwareWindow();
        }
        private JTextField textFieldA, textFieldB;
        private JButton buttonA, buttonB;
        private JTextField previouslyFocusedTextBox = textFieldA;
        public FocusAwareWindow(){
            super();
            this.setLayout(new FlowLayout());

            textFieldA = new JTextField();
            textFieldA.setText("Field A");
            textFieldA.setFocusable(true);
            textFieldA.addFocusListener(this);
            this.add(textFieldA);

            textFieldB = new JTextField();
            textFieldB.setText("Field B");
            textFieldB.setFocusable(true);
            textFieldB.addFocusListener(this);
            this.add(textFieldB);

            buttonA = new JButton("Which is focused?");
            buttonA.addActionListener(this);
            this.add(buttonA);

            this.pack();
            this.setVisible(true);;
        }
        public void actionPerformed(ActionEvent ev) {
            if(previouslyFocusedTextBox.equals(textFieldA)){
                System.out.println("Text Field A");
            } else if(previouslyFocusedTextBox.equals(textFieldB)){
                System.out.println("Text Field B");
            }
        }
        public void focusGained(FocusEvent ev) {
            if(ev.getSource() instanceof JTextField) {
                previouslyFocusedTextBox = (JTextField) ev.getSource();
            }
        }
        public void focusLost(FocusEvent ev) {
        }
    }
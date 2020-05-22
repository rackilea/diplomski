public class Trial extends JPanel implements Action Listener {

    private static final long serialVersionUID = 1L;
    private JTextField field;    //Move your declaration to class level, making it an instance variable.

    public Trial() {
        setFrame();
    }

    public void setFrame(){

        JFrame frame = new JFrame("Trial");
        JPanel panel = new JPanel();
        field = new JTextField(10);    //Remove the declaration of the variable and just initialize it here.
        JButton button = new JButton("Enter");
        button.addActionListener(this);

        panel.add(field);
        panel.add(button);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Trial();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = field.getText();   //Now you can access field within any method in the class.
        System.out.prinln("Button is pressed");
    }
}
public class CardApp extends JFrame implements ActionListener {

    private JButton oneButton, 
                    twoButton, 
                    threeButton;  
    private int width = 25;
    private private int height = 15;
    // available to all methods
    // better naming convention was JTextfield tf = new JTextField(30);
    // even stackoverflow thinks its a class name :)
    // see the color highlighting
    private JTextField TextField = new JTextField(30);

    public CardApp() {
        //JPanel boardPanel = new JPanel(new GridLayout(height,width));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        //JTextField TextField = new JTextField(30); 

        Hand settingTheText = new Hand();

        TextField.setText(settingTheText.ListOfCards());
     }
     //
     // code continues here ...
     //
}
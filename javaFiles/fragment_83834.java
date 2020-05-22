public class MyProgram extends JFrame {
    // here you declare your global variables
    private JTextInput userInput;
    private JButton okButton;
    private JComboBox myComboBox;    

    public MyProgram () {
        // here you create your objects
        okButton = new JButton("OK");
        myComboBox = new JComboBox<>();
        userInput = new JTextField();

        // then you initialize them
        myComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "First Item" }));

        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 // and that is the code that gets executed once the user clicks the button
                 String userInputText = userInput.getText(); 
                 myComboBox.addItem(userInputText);   
            }
        });
    }

    // this is what Eclipse will propably generate for you so you can launch the program and show your frame:
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyProgram().setVisible(true);
            }
        });
    }
}
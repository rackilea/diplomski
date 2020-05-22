public class JDialogTest {

    private JDialog dialog;
    private JTextField textField;

private JDialogTest (String title, JFrame frame){
    dialog = new JDialog(frame, title, true);
    dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    dialog.setMinimumSize(new Dimension(200, 200));
    init();
}

public void setVisible(Boolean flag){
    dialog.setVisible(flag);
}

public static String getInput(String title, JFrame frame){
    JDialogTest input = new JDialogTest (title, frame);
    input.setVisible(true);
    String text = input.textField.getText();
    return text;
}

private void init(){

    textField = new JTextField();
    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }

    });

    dialog.setLayout(new GridLayout(2, 1, 5, 5));

    dialog.add(textField);
    dialog.add(okButton);
    dialog.pack();     
}

public static void main(String args []){
    String s = getInput("Dialog",null);
    System.out.println(s);
}


}
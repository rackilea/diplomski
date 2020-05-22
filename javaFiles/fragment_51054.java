public class SomeActionListener implements ActionListener{

    private JTextField textField1;
    private JComboBox combo1;
    private JTextField textField2;
    //...

    public SomeActionListener(JTextField textField1, JComboBox combo1, 
                                          JTextField textField2){
        this.textField1=textField1;
        this.combo1=combo1;
        this.textField2=textField2;
        //...
    }

    public void actionPerformed(ActionEvent e) {
        //cmd
    }

}
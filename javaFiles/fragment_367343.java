public class CrudMain extends javax.swing.JInternalFrame {

public CrudMain() {
    initRadioButtons();
    initOtherStuff();
}

private JRadioButton[] radioButtons = new JRadioButton[4];
private JRadioButton btn1 = new JRadioButton();
private JRadioButton btn2 = new JRadioButton();
private JRadioButton btn3 = new JRadioButton();
private JRadioButton btn4 = new JRadioButton();
private JButton submitBtn = new JButton("Submit"); 

public void initRadioButtons() {
    radioButtons[0] = btn1;
    radioButtons[1] = btn2;
    radioButtons[2] = btn3;
    radioButtons[3] = btn4;
}

public void initOtherStuff() {
    //add stuff to your frame
    .......
    submitBtn.addActionListener(this)
}

public void actionPerformed(ActionEvent e) {
    for(int i =0; i < radioButtons.length; i++){
        if(radioButtons[i].isSelected()){
            //Open your frame here
            break; //Place break if you only want one radiobutton to be checked.
        } else {
            //This button was not selected
        }
    }
}
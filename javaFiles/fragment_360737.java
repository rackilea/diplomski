class SetNames extends JDialog {

[...]
public JButton okButton; // save okButton so others can add listeners

}


class LeadersAndSnake_Project201 extends  JFrame implements ActionListener{


// Here I made an object of Set Names  class to take the name inside the textfiled
 SetNames obj2 = new SetNames();


 public LeadersAndSnake_Project201() {
[...]
 obj2.okButton.addActionListener(new ActionListener(){/*update labels*/});

 }}
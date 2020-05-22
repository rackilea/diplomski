okButton.addActionListener(new MyAction());
public class MyAction implements ActionListener{
  public void actionPerformed(ActionEvent ae){
    JOptionPane.showMessageDialog(null, "This is the simple message 
    dialog box.", "Roseindia.net", 1);
  }
}
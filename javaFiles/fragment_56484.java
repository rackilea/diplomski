public class Execute extends JFrame {

  public Execute() 
  {
    JComboBox comboAccountName = new JComboBox(); // this guy is visible only in here
    comboAccountName.setBounds(313, 31, 302, 20);  // don't do this!
    getContentPane().add(comboAccountName);
  }
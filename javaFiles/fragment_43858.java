public class MyGUI extends JPanel
{
  private JTextField betText;

  public MyGUI(){
     //other operations
     betText = new JTextField("");
  }

  public void test(){
     String a = betText.getText();
  }
 }
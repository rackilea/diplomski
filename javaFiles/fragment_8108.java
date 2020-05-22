import javax.swing.JFrame;

public class JFrame1 extends JFrame {

    private String field1;

    public JFrame1() {
        add(new PanelA());
    } 

class PanelA extends Panel1 {

  @Override
  public String getField1() {
       return field1
  }
}
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoreTabs extends JPanel{

private JLabel lblPutStuffOn;
private JTextField text = new JTextField();

public MoreTabs(String labelText){
    lblPutStuffOn = new JLabel(labelText);
    add(lblPutStuffOn);
    add(text);
}

public String getLblText() {
    return lblPutStuffOn.getText();
}

public void setLblText(String s){
    lblPutStuffOn.setText(s);
}

public String getTxtText() {
    return text.getText();
}

public void setTxtText(String s){
    text.setText(s);
  }

}
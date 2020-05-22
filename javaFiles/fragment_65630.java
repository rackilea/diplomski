public class chkBx extends Applet implements ItemListener
{
  String msg = new String();

  TextField t1;
  Checkbox c1, c2, c3;
  Label l1;

  public void init() {
    l1 = new Label("data");
    add(l1);
    t1 = new TextField(15);
    add(t1);
    c1 = new Checkbox("nashik");
    add(c1);
    c2 = new Checkbox("pune");
    add(c2);
    c3 = new Checkbox("mumbai");
    add(c3);
    c1.addItemListener(this);
    c2.addItemListener(this);
    c3.addItemListener(this);
  }

  public void itemStateChanged(ItemEvent e) {
    String msg = "state";
    this.repaint();
  }

  public void paint(Graphics g)

  {

    t1.setText(msg);
    g.drawString(msg, 50, 100);
    msg = "city" + c1.getState();
  }
}
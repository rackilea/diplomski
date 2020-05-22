public class Example extends JDialog{
public Example() {
    setResizable(false);
    setLocation(450, 40);
    setTitle("Example panel");
    JPanel bigPanel = new JPanel();

    String name = "test name"
    String email = "email";
    JLabel label = new JLabel(name);
    JLabel label1 = new JLabel(email);
    bigPanel.add(label);
    bigPanel.add(label1);
    add(bigPanel);
    pack();
}
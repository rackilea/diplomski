public class FrameTest extends JFrame{

private JCheckBox jb1;
private JCheckBox jb2;
private JCheckBox jb3;
private JCheckBox jb4;
private JCheckBox jb5;
private JPanel jPanel1;

/**
 * Creates new form CheckBoxDinamico
 */
public FrameTest() {

    setLayout(new GridBagLayout());
    setPreferredSize(new Dimension(800, 600));
    jPanel1 = new JPanel();
    jPanel1.setLayout(new FlowLayout());
    add(jPanel1);

    jb1 = new JCheckBox("Cleaning");
    jb2 = new JCheckBox("Have dinner with friend");
    jb3 = new JCheckBox("Go sleep by 11pm");
    jb4 = new JCheckBox("Wake Up by 6am");
    jb5 = new JCheckBox();

    try {

        if(jb5.getText() == null || "".equals(jb5.getText())){
            jb5.setText(new Scanner(System.in).nextLine());
        }
        jPanel1.add(jb1);
        jPanel1.add(jb2);
        jPanel1.add(jb3);
        jPanel1.add(jb4);
        jPanel1.add(jb5);
    } catch (Exception e) {
    }
   pack();
} 

public static void main(String args[]) {
    new FrameTest().setVisible(true);
}
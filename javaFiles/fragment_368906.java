public class jManagerMainUI extends JFrame {
private JPanel panelTab1;
private JPanel panelTab2;
private JTabbedPane tabbedPane;

public jManagerMainUI(String param) {
    setContentPane(tabbedPane);
    tabbedPane.setBounds(FORM_LEFT, FORM_TOP, FORM_WIDTH, FORM_HEIGHT);
    setDefaultCloseOperation(3);
    setBounds(FORM_LEFT, FORM_TOP, FORM_WIDTH, FORM_HEIGHT);
    tabbedPane.setComponentAt(0,new jA(param).getPanel());
    tabbedPane.setComponentAt(1,new jC(param).getPanel());
    pack();
    setVisible(true);
    setSize(FORM_WIDTH, FORM_HEIGHT);
}
}
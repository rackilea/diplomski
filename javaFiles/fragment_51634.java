public class MenuBarShow extends JFrame implements ActionListener{
JMenuBar menuBar = new JMenuBar();
JMenu menu = new JMenu("A menu");
JMenuItem item;
JPanel p = new JPanel(new CardLayout());
JPanel mainPanel = new JPanel(new BorderLayout());
CardLayout cl = new CardLayout();
JPanel showThisPanel = new JPanel();

public MenuBarShow(){
    this.setVisible(true);
    this.setLayout(new BorderLayout());
    this.setSize(250,250);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    mainPanel.add(new JButton(BorderLayout.CENTER));

    cl = (CardLayout)(p.getLayout());
    p.add(showThisPanel, "STP");
    p.add(mainPanel, "MP");
    cl.show(p, "MP");
    this.add(p);


    menu = new JMenu("A menu");
    item = new JMenuItem("An item");
    item.addActionListener(this);
    menuBar.add(menu);
    menu.add(item);
    this.add(menuBar, BorderLayout.NORTH);

}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == item){
        cl.show(p, "STP");
    }
}

public static void main(String []args){

    MenuBarShow mS = new MenuBarShow();
}
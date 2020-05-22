public class MenuBarShow extends JFrame implements ActionListener{
JMenuBar menuBar = new JMenuBar();
JMenu menu = new JMenu("A menu");
JMenuItem item;
public MenuBarShow(){
    this.setVisible(true);
    this.setLayout(new BorderLayout());
    this.setSize(250,250);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    menu = new JMenu("A menu");
    item = new JMenuItem("An item");
    item.addActionListener(this);
    menuBar.add(menu);
    menu.add(item);
    this.add(menuBar, BorderLayout.NORTH);
    this.add(new JButton("Hello"), BorderLayout.CENTER);

}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == item){
      //Create new JFrame when pressing the JMenuItem
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setSize(250, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
        this.setVisible(false);
    }
}

public static void main(String []args){

    MenuBarShow mS = new MenuBarShow();

}
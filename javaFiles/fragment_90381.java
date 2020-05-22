public class MultiPanel extends JFrame {

public MultiPanel() {
int increment = 0;
while(increment < 10){
    JPanel toAdd = new JPanel();
    for (int i = 0; i < 10; i++) {
        JLabel l = new JLabel(String.valueOf(i + 1));
        JButton b = new JButton("B");
        l.setSize(50, 50);
        toAdd.setLayout(new FlowLayout(FlowLayout.CENTER));
        toAdd.add(l);
        toAdd.add(b);
    }
    add(toAdd);
    increment++;
}
setLayout(new GridLayout(1, 10));
setSize(720, 560);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] args) {
    MultiPanel m_pnl = new MultiPanel();
}
}
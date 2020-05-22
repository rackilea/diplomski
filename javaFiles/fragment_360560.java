public class test extends JFrame implements ActionListener {
    JPanel panel;

    test() {

        panel = new JPanel();
        JButton b = new JButton("1");
        b.addActionListener(this);
        panel.add(b);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.remove(panel);
        repaint();
    }

    public static void main(String a[]) {
        new test();
    }
}
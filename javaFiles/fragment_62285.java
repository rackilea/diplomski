public class JTabbedPaneDemo extends JFrame {

    public JTabbedPaneDemo() {
        JButton button = new JButton("color");
        JPanel mainpanel = new JPanel();
        JTabbedPane jtbExample = new JTabbedPane();
        JPanel jplInnerPanel1 = new JPanel();
        jtbExample.addTab("t1", jplInnerPanel1);
        jtbExample.setSelectedIndex(0);
        JPanel jplInnerPanel2 = new JPanel();
        jtbExample.addTab("t2", jplInnerPanel2);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtbExample.getSelectedComponent().setBackground(Color.yellow);
            }
        });
        setLayout(new GridLayout(1, 1));
        mainpanel.setLayout(new BorderLayout());
        mainpanel.add(jtbExample, BorderLayout.CENTER);
        mainpanel.add(button,BorderLayout.NORTH);
        this.setContentPane(mainpanel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JTabbedPaneDemo();
    }
}
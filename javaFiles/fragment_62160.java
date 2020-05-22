class DroppingFrame extends JFrame {
    final JPanel canvas = new JPanel();
    JButton button2;
    int clicked = 0;
    public DroppingFrame() {
        setSize(1400, 700);
        setTitle("Dropping");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = getContentPane();
        contentPane.add(canvas, "Center");
        JPanel p = new JPanel();

        addButton(p, "Drop ball", clicked, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Ball b = new Ball(canvas);
                b.start();
                button2.setText(String.valueOf(++clicked));
            }  
        });

        button2 = addButton(p, String.valueOf(clicked), clicked, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                canvas.setVisible(false);
                System.exit(0);
            }
        });

        contentPane.add(p, "South");
    }

    public JButton addButton(Container c, String title, int i, ActionListener a) {
        JButton b = new JButton(title);
        c.add(b);
        b.addActionListener(a);
        return b;
    }
}
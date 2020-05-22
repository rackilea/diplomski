public class ExampleFrame extends JFrame {

private JTextField jtfFirst;
private JTextField jtfSecond;
private JTextField jtfThird;
private JTextField jtfResult;

public ExampleFrame() {
    super();
    setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(5, 5, 5, 5);
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 0;
    add(new JLabel("Sum Numbers"),c);

    c.gridwidth = 1;
    c.anchor = GridBagConstraints.WEST;
    c.gridy = 1;
    add(new JLabel("Text1"),c);

    c.gridy =2;
    add(new JLabel("Text2"),c);

    c.gridy =3;
    add(new JLabel("Text3"),c);

    c.gridy =4;
    add(new JLabel("Result"),c);

    c.gridy =5;
    JButton b1 = new JButton("b1");
    b1.addActionListener(getActionB1Listener());
    add(b1,c);

    c.gridx = 1;
    c.gridy = 1;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 1;
    add(jtfFirst = new JTextField(),c);

    c.gridy = 2;
    add(jtfSecond = new JTextField(),c);

    c.gridy = 3;
    add(jtfThird = new JTextField(),c);

    c.gridy = 4;
    add(jtfResult = new JTextField(),c);
    JButton b2 = new JButton("b2");
    b2.addActionListener(getActionB2Listener());

    c.fill = GridBagConstraints.NONE;
    c.weightx = 0;
    c.gridy = 5;
    add(b2,c);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

}


private ActionListener getActionB1Listener() {
    return new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("b1 clicked");

        }
    };
}

private ActionListener getActionB2Listener() {
    return new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("b2 clicked");

        }
    };
}


public static void main(String... s) {
    new ExampleFrame();
}
}
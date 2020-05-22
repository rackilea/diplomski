private JTextField field1 = new JTextField();
private JButton addBtn = new JButton("Save: ");

 public void addComponents(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
// Components
    c.gridwidth = 1;
    c.weightx = .01;
    c.weighty = .2;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(field1, c);

        c.gridwidth = 1;
    c.weightx = .01;
    c.weighty = .2;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(addBtn, c);
}
public MainView()  {
        //Create and set up the window.
        JFrame frame = new JFrame("NAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponents(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(400, 125);
        frame.setLocation(400, 300);
    }
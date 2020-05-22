public void createUserInterface(){
    JFrame f = new JFrame("Guitar Tuner");

    f.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    });

    f.add(new LoadImageApp());
    //set LayoutManager
    f.setLayout(new FlowLayout());

    guitarJLabel = new JLabel();
    guitarJLabel.setBounds(16, 16, 90, 21);
    guitarJLabel.setText("Guitar");
    f.add(guitarJLabel);

    EButton = new JButton();
    EButton.setBounds(20, 20, 50, 50);
    EButton.setText("E");
    f.add(EButton);

    AButton = new JButton();
    AButton.setBounds(40, 40, 50, 50);
    AButton.setText("A");
    f.add(AButton);

    DButton = new JButton();
    DButton.setBounds(60, 60, 50, 50);
    DButton.setText("D");
    f.add(DButton);

    GButton = new JButton();
    GButton.setBounds(20, 100, 50, 50);
    GButton.setText("G");
    f.add(GButton);

    BButton = new JButton();
    BButton.setBounds(40, 100, 50, 50);
    BButton.setText("B");
    f.add(BButton);

    eButton = new JButton();
    eButton.setBounds(60, 100, 50, 50);
    eButton.setText("e");
    f.add(eButton);

    f.pack();
    f.setSize (500, 500);
    f.setTitle("Aaron's Awesome Guitar Tuner");
    f.setVisible(true);
}
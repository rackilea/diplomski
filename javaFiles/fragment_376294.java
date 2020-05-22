JPanel helper = new JPanel(  );
    helper.setLayout(new BoxLayout(helper, BoxLayout.Y_AXIS));
    getContentPane().add(helper);

    JPanel topPanel = new JPanel();
    helper.add(topPanel);
    JButton button1 = new JButton( "Add puncta coordinates from CSV" );
    topPanel.add(button1);
    JButton button2 = new JButton( "Add track coordinates from CSV" );
    topPanel.add(button2);

    JPanel bottomPanel = new JPanel();
    helper.add(bottomPanel);
    bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

    JPanel bottomRIght = new JPanel();
    bottomPanel.add(bottomRIght);
    JLabel label = new JLabel( "Move to time:" );
    bottomRIght.add(label);
    JTextField tMoveTime = new JTextField();
    bottomRIght.add(tMoveTime);
    tMoveTime.setColumns(15);

    JPanel bottomleftPanel = new JPanel();
    bottomPanel.add(bottomleftPanel);
    bottomleftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
    JButton bMoveTime = new JButton("Move");
    bottomleftPanel.add(bMoveTime);
initComponents();
    JPanel[] panelArray = new JPanel[5];
    JButton btnArray[] = new JButton[5];
    JPanel container = new JPanel(); // Container JPanel   
    container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS)); // With a BoxLayout
    for (int i = 0; i < 5; i++) {
        panelArray[i] = new JPanel();
        //panelArray[i].setVisible(true);
        System.out.println(panelArray[i]);
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        panelArray[i].setBackground(Color.YELLOW);
        panelArray[i].setBorder(border);
        container.add(panelArray[i]);   // Adding 5 JPanels to container JPanel
    }
    frame.getContentPane().add(container); // Adding container JPanel to JFrame
    frame.setSize(new Dimension(500, 400));
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("A Simple JFrame");
    frame.setVisible(true);
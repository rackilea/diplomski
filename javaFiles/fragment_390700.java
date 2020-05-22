JPanel menu = new JPanel();
    JButton resume = new JButton("Resume"), exit = new JButton("Exit to Main Menu");
    menu.setLayout(null);

    JFrame frame;
    frame = new JFrame("check");
    frame.setLayout(null);
    frame.setSize(300, 300);
    int[] menuSize = new int[2];
    menuSize[0] = 200;
    menuSize[1] = 300;

    menu.setLocation((frame.getWidth() - menuSize[0]) / 2, (frame.getHeight() - menuSize[1]) / 2);
    menu.setSize(menuSize[0], menuSize[1]);
    menu.setBackground(new Color(255, 255, 255));

    // resume.addActionListener((ActionListener) this);
    resume.setBounds(20, 20, 100, 100);
    resume.setFont(new Font("Sans-serif", Font.BOLD, 18));
    resume.setBackground(Color.BLACK);
    resume.setLocation(100, 100);

    resume.setVisible(true);

    // exit.addActionListener((ActionListener) this);
    exit.setFont(new Font("Sans-serif", Font.BOLD, 18));
    exit.setBackground(Color.BLACK);
    exit.setLocation(200, 100);
    exit.setVisible(true);

    menu.add(resume);
    menu.add(exit);
    frame.add(menu);
    frame.setVisible(true);
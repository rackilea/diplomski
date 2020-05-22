public static void initComponents(main main){
    JFrame loginFrame = new JFrame("Encrypted Chat - Login");
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main loginPanel = new main();
    loginPanel.setLayout(new FlowLayout());
    loginFrame.setSize(300, 125);
    loginFrame.setResizable(false);
    loginFrame.setVisible(true);
    loginFrame.add(main);  // <----- this line is added
  }
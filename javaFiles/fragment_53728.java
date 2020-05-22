setLayout(new GridBagLayout());
    GridBagConstraints gc = new GridBagConstraints();

    gc.gridy = 0;
    gc.anchor = GridBagConstraints.NORTH;

    Image image = ImageIO.read(new File("resources/Tulips.jpg"));
    JLabel label = new JLabel(new ImageIcon(image));
    JButton button1 = new JButton("Try!");

    gc.gridx = 0;
    gc.insets = new Insets(5, 5, 5, 5);
    add(label, gc);

    gc.insets = new Insets(50, 5, 5, 50);
    gc.gridx = 1;
    add(button1, gc);
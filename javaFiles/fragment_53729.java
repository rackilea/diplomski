Image image = ImageIO.read(new File("resources/Tulips.jpg"));
    JLabel label = new JLabel(new ImageIcon(image));

    setLayout(new BorderLayout(10,10));
    add(label, BorderLayout.CENTER);

    JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
    JButton button1 = new JButton("Try!");
    panel.add(button1);
    add(panel, BorderLayout.EAST);
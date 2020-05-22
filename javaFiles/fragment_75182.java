greenPanel.setLayout(new BorderLayout());
    greenPanel.add(new JLabel("test"));
    MiGPanel.add(greenPanel, "pos 0 0 33% 100%");

    JPanel yellowPanel = new JPanel();
    yellowPanel.setBackground(Color.yellow);
    MiGPanel.add(yellowPanel, "pos 33% 0 66% 100%");

    JPanel bluePanel = new JPanel();
    bluePanel.setBackground(Color.blue);
    MiGPanel.add(bluePanel, "pos 66% 0 100% 100%");
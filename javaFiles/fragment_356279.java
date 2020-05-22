frame.setJMenuBar(battlegui.createMenu());

    JPanel gui = new JPanel(new GridLayout(1,2,5,5));
    gui.setBorder(new EmptyBorder(5,5,5,5));
    gui.add(battlegui.createContentPane());
    gui.add(battlegui.createContentPane());
    frame.setContentPane(gui);
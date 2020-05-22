mScreen = new VideoImage();     

    Panel controlPanel = new Panel();               
    controlPanel.setBounds(new Rectangle(10, 10, 10, 10));
    controlPanel.setMaximumSize(new Dimension(10, 10));
    Container cont = mScreen.getContentPane();
    cont.add(controlPanel, BorderLayout.SOUTH);
public button(String backgroundPath, int y, MenuPanel menuPanel)
    {
        this.backgroundPath = backgroundPath;
        this.y = y;

        buttonImage = new ImageIcon(PlayPanel.class.getResource(backgroundPath));
        button = new JButton();
        button.setBounds(x, y, width, height);;
        button.addActionListener(menuPanel); 
    }
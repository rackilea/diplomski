gamePanel.removeAll();
    gamePanel.fillGrid();
    gamePanel.revalidate();
    gamePanel.repaint();
    Tuple position = new Tuple(10, 10);
    this.gamePanel = new GamePanel(this);
    this.add(gamePanel,BorderLayout.CENTER);
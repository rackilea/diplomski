JButton StartButton = new JButton();
      try {
        Image startImage =ImageIO.read(getClass().getResource("/textures/StartButton.png"));
        StartButton.setIcon(new ImageIcon(startImage));
      } catch (Exception ex) {
        System.out.println(ex);
      }
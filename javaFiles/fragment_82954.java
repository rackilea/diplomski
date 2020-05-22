JButton yourButton = new JButton("text button");
        try {
            yourButton.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/images/icon-for-your-button.png"))));
        } catch (IOException e3) {
            // TODO Auto-generated catch block
            e3.printStackTrace();
        }
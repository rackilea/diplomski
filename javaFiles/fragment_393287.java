try {
        img = ImageIO.read(new File("graphics/close_0.jpg"));
        remoteController = ImageIO.read(new File("graphics/pilot.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
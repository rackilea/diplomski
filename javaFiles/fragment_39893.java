BufferedImage myPicture = null;
    try {
        URL url = new URL("https://www.w3schools.com/css/img_fjords.jpg");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "MyAppName");
        myPicture = ImageIO.read(url);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    frame.getContentPane().add(picLabel);
if(actionCommand.equals("Image 1")) {
    JLabel addImage = new JLabel();
    URL url = getClass().getResource("picture1.jpg");
    if (url != null) {
        ImageIcon image = new ImageIcon(url);
        addImage.setIcon(image);
        imagePanel.add(addImage);
        imagePanel.setBackground(Color.yellow);
        this.revalidate();
    }
}
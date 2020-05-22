public DrawPanel()
 {
    this.setLayout(new BorderLayout());

    ImageResizer imageResizer = new ImageResizer();
    ImageIcon imageIcon = imageResizer.resize(1024, 768, "res/test.png");
    image = imageIcon.getImage();
 }
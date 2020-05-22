Image image1 = new Image(MainGUI.class.getResourceAsStream("/com/image1.png"));
Image image2 = new Image(MainGUI.class.getResourceAsStream("/com/stackoverflow/image2.png"));
Image image3 = new Image(MainGUI.class.getResourceAsStream("/image3.png"));

// So in your case, you would change your line to this:
img1 = new Image(MainGUI.class.getResourceAsStream("/add_medication_button.png"));
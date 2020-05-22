public IconDemoApp() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Icon Demo: Please Select an Image");

    // A label for displaying the pictures
    photographLabel.setVerticalTextPosition(JLabel.BOTTOM);
    photographLabel.setHorizontalTextPosition(JLabel.CENTER);
    photographLabel.setHorizontalAlignment(JLabel.CENTER);
    photographLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    // We add two glue components. Later in process() we will add thumbnail buttons
    // to the toolbar inbetween thease glue compoents. This will center the
    // buttons in the toolbar.
    buttonBar.add(Box.createGlue());
    buttonBar.add(Box.createGlue());

    add(buttonBar, BorderLayout.SOUTH);
    add(photographLabel, BorderLayout.CENTER);

    setSize(400, 300);

    // this centers the frame on the screen
    setLocationRelativeTo(null);

    // start the image loading SwingWorker in a background thread
    loadimages.execute();
}
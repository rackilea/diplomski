public static JFrame openInJFrame(Container content, int width, int height,
        String title, Color bgColor) {

    // ...
    frame.setContentPane(content);      

    frame.setVisible(true);
    return (frame);
}
public FileChooserFrame() {//construct a JFrame
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); //maximize to full screen
    JFileChooser fc = new JFileChooser(); //construct file chooser
    add(fc); //add file chooser to frame
    setVisible(true);
}
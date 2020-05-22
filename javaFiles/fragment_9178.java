public PicPanel() {
    super();
    try {
        rUrl = getClass().getResource("Table.jpg");
        if (rUrl != null) {
            img = ImageIO.read(rUrl);
        }
    } catch (IOException ex) {
        Logger.getLogger(PicPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
}
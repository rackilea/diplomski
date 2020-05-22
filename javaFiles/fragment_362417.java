public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btn) {
        File oldimage = new File(picture);
        BufferedImage buffimage = null;
        try {
            buffimage = ImageIO.read(oldimage);
        } catch (IOException ex) {
            Logger.getLogger(Movie_Poster_UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage resized = resize(buffimage, 500, 700);
        lbl.setIcon(new ImageIcon(resized));
        File newimage = new File(picture2);
        try {
            ImageIO.write(resized, "png", newimage);
        } catch (IOException ex) {
            Logger.getLogger(Movie_Poster_UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if (e.getSource() == btn2) {
        lbl.setIcon(image2);
    }
}
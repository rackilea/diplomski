private JLabel imageLabel;
private void newImage() throws MalformedURLException, IOException {
    ...
    imageLabel.setIcon(icon); 
    revalidate();    
    repaint();
}
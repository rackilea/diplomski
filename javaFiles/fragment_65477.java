public Image retrieveImage(String x){
    URL y = this.getClass().getResource(x);
    Image img = tk.getImage(y);
    if (img == null)
        throw new IllegalArgumentException("image " + x + " not found");
    return new ImageIcon(img).getImage();
}
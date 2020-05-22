@Override     
public Dimension getPreferredSize() {
    int height = calculateHeight(); 
    int width = calculateWidth(); 
    return new Dimension(width, height);
}
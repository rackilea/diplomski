@Override
public void setText(String arg0) {
    super.setText(arg0);
    FontMetrics metrics = getFontMetrics(getFont()); 
    int width = metrics.stringWidth( getText() );
    int height = metrics.getHeight();
    Dimension newDimension =  new Dimension(width+40,height+10);
    setPreferredSize(newDimension);
    setBounds(new Rectangle(
                   getLocation(), getPreferredSize()));
}
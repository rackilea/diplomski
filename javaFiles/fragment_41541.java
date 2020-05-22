Image i = icon.getImage();
if(i != null){
   int width = (int)(size * fraction);
   int height =(int)(size*icon.getIconHeight()/icon.getIconWidth()*fraction);
   miniature = new ImageIcon(i.getScaledInstance(width, height, Image.SCALE_SMOOTH));
}
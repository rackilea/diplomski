private class SearchField extends JTextField{

   private final int fieldWidth = 375;
   private final int fieldHeight = 30;
   private final Font fieldFont = FontLoader.getCustomFont("Gotham-Bold.ttf", 15);
   private final Color foreground = ColorConstants.SEARCH_FIELD_FOREGROUND;
   private final Color background = ColorConstants.SEARCH_FIELD_BACKGROUND;

   public SearchField(){
      super();
      this.setOpaque(false);
      this.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
      this.setBorder(new EmptyBorder(5,5,5,5));
      this.setFont(fieldFont);
      this.setForeground(new Color(0,0,0,0));
      this.setSelectedTextColor(new Color(0,0,0,0));
   }

   @Override
   public void paintComponent(Graphics paramGraphics){
      Graphics2D g = (Graphics2D) paramGraphics.create();
      GraphicUtils.enableAntiAliasing(g); //RenderingHints
      g.setColor(background);
      g.fillRoundRect(0, 0, fieldWidth, fieldHeight, 4, 4);
      super.paintComponent(g);
      g.setColor(foreground);
      g.drawString(this.getText(), 5, 20);
   }
}
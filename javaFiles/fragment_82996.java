class Lights {
   private final int RED = 1;
   private final int YELLOW = 2;

   // .... etc....

   private Rectangle grayBG, blackBG;
   private Circle red, green, yellow, redFore, greenFore, yellowFore;

   public Lights() {
      // the variables below are **local** to the constructor!
      Rectangle grayBG = new Rectangle(35, 35, 280, 830, true);
      Rectangle blackBG = new Rectangle(50, 50, 250, 800, true);
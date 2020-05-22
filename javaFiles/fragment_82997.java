class Lights {
   private final int RED = 1;
   private final int YELLOW = 2;

   // .... etc....

   private Rectangle grayBG, blackBG;
   private Circle red, green, yellow, redFore, greenFore, yellowFore;

   public Lights() {
      grayBG = new Rectangle(35, 35, 280, 830, true); // *** note the difference
      blackBG = new Rectangle(50, 50, 250, 800, true); // *** note the difference
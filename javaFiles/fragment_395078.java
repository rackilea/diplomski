class HisTestButton {
   protected static final int PREF_W = 200;
   protected static final int PREF_H = 200;
   JDialog dialog; // !! make this a JDialog
   GridBagLayout grid = new GridBagLayout();
   private Test test;  //!! add field   ****************

   //!! changed constructor parameter
   public HisTestButton(final Test test) { // *****
      this.test = test; // !! set field
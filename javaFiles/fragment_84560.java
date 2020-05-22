public class LabelAlignScreen extends MainScreen {

   private LabelField description;
   private LabelField balance;
   private static final int MARGIN = 8;  // used for x and y

   public LabelAlignScreen() {
      super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);

      Manager row = new RowManager(Manager.USE_ALL_WIDTH);
      description = new LabelField("This is a very looooooooooong description", 
            LabelField.ELLIPSIS);
      row.add(description);
      balance = new LabelField("1,500,000,000 USD");
      row.add(balance);
      add(row);
   }

   private class RowManager extends Manager {
      public RowManager(long flags) {
         super(flags);
      }

      protected void sublayout(int width, int height) {
         // first, determine how much space the balance field needs
         int balanceWidth = balance.getFont().getAdvance(balance.getText());
         // description field gets leftover width, 
         //   minus a margin at left, center and right
         int descriptionWidth = width - balanceWidth - 3 * MARGIN;

         setPositionChild(description, MARGIN, MARGIN);
         layoutChild(description, descriptionWidth, description.getPreferredHeight());

         setPositionChild(balance, MARGIN + descriptionWidth + MARGIN, MARGIN);
         layoutChild(balance, balanceWidth, balance.getPreferredHeight());  

         setExtent(width, getPreferredHeight());
      }

      public int getPreferredHeight() {
         return Math.max(balance.getPreferredHeight(), description.getPreferredHeight()) + 2 * MARGIN;
      }

      public int getPreferredWidth() {
         return Display.getWidth();
      }
   }
}
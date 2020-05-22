public class CustomColorChoiceField extends ObjectChoiceField {

      public CustomColorChoiceField(String label, Object[] choices, int initialIndex) {
         super("title", choices, initialIndex);
      }

      protected void paint(Graphics graphics) {
         int oldColor = graphics.getColor();
         graphics.setColor(Color.GREEN);
         super.paint(graphics);
         graphics.setColor(oldColor);
      }
   }
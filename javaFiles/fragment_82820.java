import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.util.Arrays;

public class CustomTextField extends VerticalFieldManager {

   private int textWidth = 0;
   private int textHeight = 0;
   private CustomHorizontalFieldManager hfm;

   public CustomTextField(int width, int height) {
      super();

      textWidth = width;
      textHeight = height;

      hfm = new CustomHorizontalFieldManager();
      add(hfm);
   }

   protected void sublayout(int maxWidth, int maxHeight) {
      super.sublayout(textWidth, textHeight);
      setExtent(textWidth, textHeight);
   }

   protected void paint(Graphics graphics) {
      // TODO: change me!
      super.paint(graphics);
      graphics.setColor(Color.BLACK);
      graphics.drawRect(0, 0, textWidth, textHeight);
   }

   private class CustomHorizontalFieldManager extends HorizontalFieldManager implements FieldChangeListener {

      private BasicEditField basicEditField;
      /** the maximum virtual width of the edit field, based on the max num of chars */
      private int maxVirtualWidth;

      public CustomHorizontalFieldManager() {
         super(Manager.HORIZONTAL_SCROLL);

         int maxNumChars = 200;
         basicEditField = new BasicEditField("", "", maxNumChars, BasicEditField.NO_NEWLINE);

         // determine how wide the field would need to be to hold 'maxNumChars', with the font
         //   in use ... just pick a long string of all W's, since that's usually the widest char
         char[] buffer = new char[maxNumChars];
         Arrays.fill(buffer, 'W');
         String spacer = new String(buffer);
         maxVirtualWidth = basicEditField.getFont().getAdvance(spacer);

         // we need to listen as the user types in this field, so we can dynamically alter its
         //   virtual width
         basicEditField.setChangeListener(this);

         add(basicEditField);
      }

      protected void sublayout(int maxWidth, int maxHeight) {
         super.sublayout(maxWidth, maxHeight);
         // extent is the visible size, virtual extent can be wider if we want scrolling
         setExtent(textWidth, textHeight);
         setVirtualExtent(maxVirtualWidth, textHeight);
      }

      public void fieldChanged(Field f, int context) {
         if (f == basicEditField) {
            // recalculate how much virtual width the edit field needs, based on the 
            //  current text content
            int newWidth = basicEditField.getFont().getAdvance(basicEditField.getText());
            setVirtualExtent(newWidth, textHeight);
         }
      }
   }

}
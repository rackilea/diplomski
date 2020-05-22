public class JMyFontLabel extends JLabel {
  boolean applyFontChange = false;

  public JMyFontLabel(String text, boolean applyFontChange) {
         super(text);
         this.applyFontChange = applyFontChange;
  }

  // get / set methods for applyFontChange.
} 

// Method to apply font
public void setMyFont(JPanel examplePanel, Font myFont) {
   Component[] components = examplePanel.getComponents();

   for (Component singleComponent : components) {

   if (singleComponent instanceof JMyFontLabel) {
       JMyFontLabel label = (JMyFontLabel) singleComponent;

       if (label.isApplyFontChange()) {
          label.setFont(myFont);
       }
   }
}
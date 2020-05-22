/**
 * Disables (and can again Enable) the TAB (or SHIFT-TAB), BACKSPACE, and DELETE keys when 
 * used within the supplied JTextField.<br><br>
 * 
 * When the Tab key or Backspace key is hit then it can be detected within the 
 * JTextField's KeyPressed Event by way of:<pre>
 * 
 *      if (event.getKeyCode() == KeyEvent.VK_TAB) {
 *          System.out.println("TAB Key Pressed!");
 *      } 
 *      else if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
 *          System.out.println("BACKSPACE Key Pressed!");
 *      }</pre>
 * 
 * @param jtextfield (JTextField) The desired JTextField variable name to 
 * control.<br>
 * 
 * @param ON_OFF (Optional - Boolean - Default is true) If true (default) then 
 * Tab and Backspace is not allowed within the supplied JTextField. If false is 
 * supplied then Tab and Backspace is allowed within the supplied JTextField.
 */
public void noTABorBACKSPACE(JTextField jtextfield, boolean... ON_OFF) {
    boolean on = true;  // Default ON - No Tab Away and No Backspace allowed.
    if (ON_OFF.length > 0) {
        on = ON_OFF[0];
    }
    if (on) {
        // Remove the TAB Away feature from the JTextField.
        jtextfield.setFocusTraversalKeysEnabled(!on);

        // Disable the Backspace feature from the JTextField.
        // This is done with a custom Document Filter.
        ((AbstractDocument) jtextfield.getDocument()).setDocumentFilter(
            new DocumentFilter(){
                @Override
                // By overriding the remove() method with an empty remove() 
                // method we effectively eliminate Backspace capabilities.
                public void remove(DocumentFilter.FilterBypass fb, int i, int i1) 
                    throws BadLocationException {  }
            }
        );
    }
    else {
        // Re-enable the TAB Away feature for the JTextField.
        jtextfield.setFocusTraversalKeysEnabled(!on);

        // Re-enable the Backspace feature for the JTextField.
        // This is done by removing our custom Document Filter.
        ((AbstractDocument) jtextfield.getDocument()).setDocumentFilter(null);
    }
}
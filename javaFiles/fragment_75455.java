/**
 * This method shows an INFORMATION_MESSAGE type message dialog.
 *
 * @param parentComponent The component to find a frame in.
 * @param message The message displayed.
 */
public static void showMessageDialog(Component parentComponent, Object message){
  JOptionPane pane = new JOptionPane(message, INFORMATION_MESSAGE);
  JDialog dialog = pane.createDialog(parentComponent, null);
  dialog.show();   
}
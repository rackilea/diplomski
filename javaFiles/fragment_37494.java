public class AClass
{
    /* declared here in order to be visible both from thing1 and to ActionPerformed */
    private String File1 = null;

    /* thing1 */
    public void AMethod() {
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(true);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File1 = chooser.getCurrentDirectory() + "";
            fileTextField.setText(File1);
        } else
            JOptionPane.showMessageDialog(null,"No Selection ");
    }

    /* ... */

    /* ActionPerformed */
    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        thing2(File1);
    }
}
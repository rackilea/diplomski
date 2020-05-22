// imports and other code left out

public class ConfigBox extends javax.swing.JFrame {
    // curDir will hold the absolute path to 'home\'
    String curDir; // add this line

    /**
     * Creates new form ConfigBox
     */
    public ConfigBox() 
    {
        // this is where curDir gets set to the absolute path of 'home/'
        curDir = new File("").getAbsolutePath(); // add this line

        initComponents();
    }

    /*
     * irrelevant code
     */

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Runtime rt = Runtime.getRuntime();

        // filePath is set to 'home\docs\READTHIS.txt'
        String filePath = curDir + "\\docs\\READTHIS.txt"; // add this line

        try {
            Process p = rt.exec("notepad " + filePath); // add filePath
        } catch (IOException ex) {
            Logger.getLogger(NumberAdditionUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /*
     * irrelevant code
     */
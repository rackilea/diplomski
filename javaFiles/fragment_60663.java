import org.apache.batik.bridge.UserAgent;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.util.XMLConstants;

/**
 *
 * @author
 */
public class myJSVGCanvas extends JSVGCanvas{

@Override
protected UserAgent createUserAgent() {
    return new myCanvasUserAgent();
}

protected class myCanvasUserAgent extends CanvasUserAgent

    implements XMLConstants {

    /**
     * Displays an error message in the User Agent interface.
     */
    @Override
    public void displayError(String message) {
        if (svgUserAgent != null) {
            super.displayError(message);
        } else {
            System.out.println(message);
//            JOptionPane pane =
//                new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
//            JDialog dialog =
//                pane.createDialog(myJSVGCanvas.this, "ERROR");
//            dialog.setModal(false);
//            dialog.setVisible(true); // Safe to be called from any thread
        }
    }

    /**
     * Displays an error resulting from the specified Exception.
     */
    @Override
    public void displayError(Exception ex) {
        if (svgUserAgent != null) {
            super.displayError(ex);
        } else {
            ex.printStackTrace();
//            JErrorPane pane =
//                new JErrorPane(ex, JOptionPane.ERROR_MESSAGE);
//            JDialog dialog = pane.createDialog(myJSVGCanvas.this, "ERROR");
//            dialog.setModal(false);
//            dialog.setVisible(true); // Safe to be called from any thread
        }
    }
}    
}
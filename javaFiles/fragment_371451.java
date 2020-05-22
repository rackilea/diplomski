/*
 * TabFolder example snippet: create a tab folder (six pages)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class TabItemDisable {

public static void main (String [] args) {
    Display display = new Display ();
    final Shell shell = new Shell (display);
    final TabFolder tabFolder = new TabFolder (shell, SWT.BORDER);
    Rectangle clientArea = shell.getClientArea ();
    tabFolder.setLocation (clientArea.x, clientArea.y);
    for (int i=0; i<6; i++) {
        TabItem item = new TabItem (tabFolder, SWT.NONE);
        item.setText ("TabItem " + i);
        Button button = new Button (tabFolder, SWT.PUSH);
        button.setText ("Page " + i);
        item.setControl (button);
    }
    tabFolder.pack ();

    // disabling content of selected TabItems
    tabFolder.getTabList()[0].setEnabled(false);
    tabFolder.getTabList()[2].setEnabled(false);
    tabFolder.getTabList()[4].setEnabled(false);

    shell.pack ();
    shell.open ();
    while (!shell.isDisposed ()) {
        if (!display.readAndDispatch ()) display.sleep ();
    }
    display.dispose ();
}
}
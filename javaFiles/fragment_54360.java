import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonTest extends Shell {

    /**
     * Launch the application.
     * @param args
     */

    // Code starts here in main.
    public static void main(String args[]) {
        try {
            Display display = Display.getDefault();
            // Creates a window (shell) called "shell"
            ButtonTest shell = new ButtonTest(display);
            // These two lines start the shell.
            shell.open();
            shell.layout();

            // Now we can start adding stuff to our shell.

            // The size of the window.
            Rectangle bounds = shell.getBounds();

            // How many rows of buttons.
            int numOfRows = 5;

            // How many buttons per row.
            int numOfColumns = 3;

            int buttonWidth = bounds.width / numOfRows;
            int buttonHeight = bounds.height / numOfColumns;

        Button button;

        int x = 0;
        int y = 0;

        for(int i = 0; i < numOfColumns; i++){
            for(int j = 0; j < numOfRows; j++){
                button = new Button(shell, SWT.NONE);
                button.setBounds(x, y, buttonWidth, buttonHeight);
                x += buttonWidth;
            }
            x = 0;
            y += buttonHeight;
        }



        // This loop keeps the shell from killing itself the moment it's opened
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/**
 * Create the shell.
 * @param display
 */
public ButtonTest(Display display) {
    super(display, SWT.SHELL_TRIM);
    createContents();
}

/**
 * Create contents of the shell.
 */
protected void createContents() {
    setText("SWT Application");
    setSize(800, 800);

}

@Override
protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
}
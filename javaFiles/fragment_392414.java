import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.RECT;
import org.eclipse.swt.widgets.*;

public class CaptionItemSnippet {

    private static final char[] WINDOW_CLASS = className("WINDOW");
    private static final int WP_MINBUTTON = 15;
    private static final int WP_MAXBUTTON = 17;
    private static final int WP_CLOSEBUTTON = 18;

    private static final int DFC_CAPTION = 1;

    private static final int DFCS_CAPTIONCLOSE = 0x0000;
    private static final int DFCS_CAPTIONMIN = 0x0001;
    private static final int DFCS_CAPTIONMAX = 0x0002;
    private static final int DFCS_CAPTIONRESTORE = 0x0003;
    private static final int DFCS_CAPTIONHELP = 0x0004;

    public static void main(String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);

        int gwlStyle = OS.GetWindowLong(shell.handle, OS.GWL_STYLE);
        //remove title bar
        gwlStyle &= ~OS.WS_CAPTION;
        // add maximize button: does not work
        gwlStyle |= OS.WS_SYSMENU | OS.WS_MAXIMIZEBOX;
        OS.SetWindowLong(shell.handle, OS.GWL_STYLE, gwlStyle & ~OS.WS_CAPTION);

        final Button minimizeButton = createButton(shell, WP_MINBUTTON, DFCS_CAPTIONMIN);
        minimizeButton.setBounds(125, 0, 20, 20);
        final Button maxButton = createButton(shell, WP_MAXBUTTON, DFCS_CAPTIONMAX);
        maxButton.setBounds(145, 0, 20, 20);
        final Button closeButton = createButton(shell, WP_CLOSEBUTTON, DFCS_CAPTIONCLOSE);
        closeButton.setBounds(165, 0, 20, 20);

        shell.setSize(200, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private static Button createButton(final Composite parent, final int partId, final int uState) {
        final Button button = new Button(parent, SWT.PUSH);
        button.addListener(SWT.Paint, new Listener() {
            @Override
            public void handleEvent(Event e) {
                final Point size = button.getSize();
                final RECT rect = new RECT();
                rect.left = 0;
                rect.right = size.x;
                rect.top = 0;
                rect.bottom = size.y;

                if (OS.IsAppThemed()) {
                    final int theme = OS.OpenThemeData(parent.handle, WINDOW_CLASS);
                    OS.DrawThemeBackground(theme, e.gc.handle, partId, OS.TS_NORMAL, rect, null);
                    OS.CloseThemeData(theme);
                } else {
                    OS.DrawFrameControl(e.gc.handle, rect, DFC_CAPTION, uState);
                }
            }
        });
        return button;
    }

    private static char[] className(String s) {
        final char[] chars = new char[s.length() + 1];
        System.arraycopy(s.toCharArray(), 0, chars, 0, s.length());
        chars[chars.length - 1] = 0;
        return chars;
    }
}
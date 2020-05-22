import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TestWindow {

    private static int CONST_WIDTH = 200;

    public static void main(String[] args) {
        Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setBounds(shell.getBounds().x, shell.getBounds().y, CONST_WIDTH, shell.getBounds().height);
        shell.setText("Test");

        shell.addControlListener(new ControlAdapter() {

            @Override
            public void controlResized(ControlEvent e) {
                Rectangle rect = shell.getBounds();
                if(rect.width != CONST_WIDTH) {
                    shell.setBounds(rect.x, rect.y, CONST_WIDTH, rect.height);
                }
            }
        });

        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
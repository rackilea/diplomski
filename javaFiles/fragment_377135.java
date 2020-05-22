import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * SWT composite with transparent label
 * 
 * @author McDowell
 */
public class Sweet {

    private Image imageGradient;
    private Label label;
    private Composite composite;

    private void createComponents(Shell parent) {
        composite = new Composite(parent, SWT.NONE);
        composite.addListener(SWT.Resize, new Listener() {
            public void handleEvent(Event e) {
                changeImage();
            }
        });
        composite.setLayout(new FormLayout());
        composite.setBackgroundMode(SWT.INHERIT_DEFAULT);

        label = new Label(composite, SWT.None);
        label.setText("Hello, World!");
    }

    private void changeImage() {
        Image oldImage = imageGradient;

        Display display = composite.getDisplay();
        Rectangle rect = composite.getClientArea();
        imageGradient = new Image(display, rect.width, rect.height);
        GC gc = new GC(imageGradient);
        try {
            Color color1 = new Color(display, 200, 200, 255);
            try {
                Color color2 = new Color(display, 255, 255, 255);
                try {
                    gc.setForeground(color1);
                    gc.setBackground(color2);
                    gc.fillGradientRectangle(rect.x, rect.y, rect.width,
                            rect.height, true);
                } finally {
                    color2.dispose();
                }
            } finally {
                color1.dispose();
            }
        } finally {
            gc.dispose();
        }
        composite.setBackgroundImage(imageGradient);

        if (oldImage != null) {
            oldImage.dispose();
        }
    }

    private void openShell(Display display) {
        Shell shell = new Shell(display);
        try {
            shell.setSize(200, 100);
            shell.setLayout(new FillLayout());
            createComponents(shell);
            shell.open();
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
        } finally {
            if (!shell.isDisposed()) {
                shell.dispose();
            }
        }
    }

    public void run() {
        Display display = Display.getDefault();
        try {
            openShell(display);
        } finally {
            display.dispose();
        }
    }

    public void dispose() {
        if (imageGradient != null) {
            imageGradient.dispose();
        }
    }

    public static void main(String[] args) {
        Sweet sweet = new Sweet();
        try {
            sweet.run();
        } finally {
            sweet.dispose();
        }
    }

}
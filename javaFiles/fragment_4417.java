import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HeadLess 
{
    public static void main(String[] args) {
        new HeadLess().start();
    }

    public void start()
    {
        Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, true));
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        shell.setLayoutData(gridData);

        // Create browser and listen for events in headless mode
        final Browser browser = new Browser(shell, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        browser.setLayoutData(gridData);

        browser.setUrl("https://stackoverflow.com/questions/12193231/is-there-an-equivalent-to-java-awt-headless-true-for-swt");
        browser.addProgressListener(new ProgressListener() {
            public void completed(ProgressEvent event) {
                System.out.println(browser.getText());
                shell.close();
            }
            public void changed(ProgressEvent event) {
            }
        });

        browser.addLocationListener(new LocationListener() {
            public void changing(LocationEvent event) {
                System.out.println(event.location);
            }
            public void changed(LocationEvent event) {
            }
        });

        // Creating image in headless mode !!
        Color red = new Color(display, new RGB(255, 0, 0));
        Image image = new Image(display, 100, 100);
        GC gc = new GC(image);
        gc.setBackground(red);
        gc.fillRectangle(image.getBounds());
        gc.dispose();

        ImageLoader loader = new ImageLoader();
        loader.data = new ImageData[] {image.getImageData()};
        loader.save("swt.png", SWT.IMAGE_PNG);

        red.dispose();
        image.dispose();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}
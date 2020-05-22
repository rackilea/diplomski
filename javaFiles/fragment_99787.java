package swttest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        test.show();
    }

    public void show() {
        Display display = new Display();
        // Create a shell with no trim
        final Shell shell = new Shell(display, SWT.NO_TRIM);
        shell.setForeground(display.getSystemColor(SWT.COLOR_WHITE));

        //set the transparent canvas on the shell
        Canvas canvas = new Canvas(shell, SWT.NO_BACKGROUND);

        //create an area to paint the text
        Rectangle size = new Rectangle(0, 0, 200, 200);
        canvas.setBounds(size);

        Region region = canvas.getRegion();

        //mucking about with fonts
        Font font = display.getSystemFont();

        FontData[] fd = font.getFontData();

        fd[0].setHeight(24);
        fd[0].setStyle(SWT.BOLD);

        Font bigFont = new Font(display, fd[0]);
        canvas.setFont(bigFont);

        // define the shape of the shell using setRegion
        shell.setRegion(region);
        shell.setSize(size.width, size.height);

        canvas.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                e.gc.drawString("Hello", 10, 10, true);
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        region.dispose();
        display.dispose();
    }
}
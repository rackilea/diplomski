import java.io.InputStream;
import java.net.URL;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Zoom implements PaintListener, MouseMoveListener, MouseListener {
    private static final int MOUSE_DOWN = 1;
    private static final int DRAGGING = 2;
    private static final int NOT_DRAGGING = 3;

    int dragState = NOT_DRAGGING;
    Point zoomStart;
    Point zoomEnd;

    ImageData imgData;
    Image img;
    Transform paintTransform;
    Shell shell;
    Color rectColor;

    public Zoom(ImageData image, Shell shell) {
        imgData = image;
        img = new Image(shell.getDisplay(), image);
        this.shell = shell;
        rectColor = new Color(shell.getDisplay(), new RGB(255, 255, 255));
    }

    void zoom() {
        int x0 = Math.min(zoomStart.x, zoomEnd.x);
        int x1 = Math.max(zoomStart.x, zoomEnd.x);
        int y0 = Math.min(zoomStart.y, zoomEnd.y);
        int y1 = Math.max(zoomStart.y, zoomEnd.y);

        setVisibleImageAreaInScreenCoordinates(x0, y0, x1, y1);
    }

    void setVisibleImageAreaInImageCoordinates(float x0, float y0,
            float x1, float y1) {
        Point sz = shell.getSize();

        double width = x1 - x0;
        double height = y1 - y0;

        double sx = (double) sz.x / (double) width;
        double sy = (double) sz.y / (double) height;

        float scale = (float) Math.min(sx, sy);

        // compute offset to center selected rectangle in available area
        double ox = 0.5 * (sz.x - scale * width);
        double oy = 0.5 * (sz.y - scale * height);

        paintTransform.identity();
        paintTransform.translate((float) ox, (float) oy);
        paintTransform.scale(scale, scale);
        paintTransform.translate(-x0, -y0);
    }

    void setVisibleImageAreaInScreenCoordinates(int x0, int y0,
            int x1, int y1) {
        Transform inv = invertPaintTransform();
        // points in screen coordinates
        // to be transformed to image coordinates
        // (top-left and bottom-right corner of selection)
        float[] points = { x0, y0, x1, y1 };

        // actually get image coordinates
        // (in-place operation on points array)
        inv.transform(points);
        inv.dispose();

        // extract image coordinates from array
        float ix0 = points[0];
        float iy0 = points[1];
        float ix1 = points[2];
        float iy1 = points[3];

        setVisibleImageAreaInImageCoordinates(ix0, iy0, ix1, iy1);
    }

    Transform invertPaintTransform() {
        // clone paintTransform
        float[] elems = new float[6];
        paintTransform.getElements(elems);
        Transform inv = new Transform(shell.getDisplay());
        inv.setElements(elems[0], elems[1], elems[2],
                        elems[3], elems[4], elems[5]);

        // invert clone
        inv.invert();
        return inv;
    }

    void fitImage() {
        Point sz = shell.getSize();

        double sx = (double) sz.x / (double) imgData.width;
        double sy = (double) sz.y / (double) imgData.height;

        float scale = (float) Math.min(sx, sy);

        paintTransform.identity();
        paintTransform.translate(sz.x * 0.5f, sz.y * 0.5f);
        paintTransform.scale(scale, scale);
        paintTransform.translate(-imgData.width*0.5f, -imgData.height*0.5f);
    }

    @Override
    public void paintControl(PaintEvent ev) {
        if (paintTransform == null) {
            paintTransform = new Transform(shell.getDisplay());
            fitImage();
        }

        ev.gc.setTransform(paintTransform);
        ev.gc.drawImage(img, 0, 0);

        if (dragState == DRAGGING) {
            drawZoomRect(ev.gc);
        }
    }

    void drawZoomRect(GC gc) {
        int x0 = Math.min(zoomStart.x, zoomEnd.x);
        int x1 = Math.max(zoomStart.x, zoomEnd.x);
        int y0 = Math.min(zoomStart.y, zoomEnd.y);
        int y1 = Math.max(zoomStart.y, zoomEnd.y);

        gc.setTransform(null);

        gc.setAlpha(0x80);
        gc.setForeground(rectColor);
        gc.fillRectangle(x0, y0, x1 - x0, y1 - y0);
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/"  +
                "6/62/Billy_Zoom.jpg/800px-Billy_Zoom.jpg");
        InputStream input = url.openStream();
        ImageData img;
        try {
            img = new ImageData(input);
        } finally {
            input.close();
        }

        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(800, 600);

        Zoom zoom = new Zoom(img, shell);

        shell.open();
        shell.addPaintListener(zoom);
        shell.addMouseMoveListener(zoom);
        shell.addMouseListener(zoom);

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    @Override
    public void mouseDoubleClick(MouseEvent e) {
    }

    @Override
    public void mouseDown(MouseEvent e) {
        if (e.button != 1) {
            return;
        }
        zoomStart = new Point(e.x, e.y);
        dragState = MOUSE_DOWN;
    }

    @Override
    public void mouseUp(MouseEvent e) {
        if (e.button != 1) {
            return;
        }
        if (dragState == DRAGGING) {
            zoomEnd = new Point(e.x, e.y);
        }
        dragState = NOT_DRAGGING;
        zoom();
        shell.redraw();
    }

    @Override
    public void mouseMove(MouseEvent e) {
        if (dragState == NOT_DRAGGING) {
            return;
        }
        if (e.x == zoomStart.x && e.y == zoomStart.y) {
            dragState = MOUSE_DOWN;
        } else {
            dragState = DRAGGING;
            zoomEnd = new Point(e.x, e.y);
        }
        shell.redraw();
    }
}
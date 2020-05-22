import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.umd.cs.piccolo.PCamera;
import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolo.nodes.PText;
import edu.umd.cs.piccolo.util.PPaintContext;
import edu.umd.cs.piccolox.PFrame;

public class TestRectZoom extends PFrame {
    public TestRectZoom() {
        super("TestRectZoom", false, null);
    }

    public void initialize() {
        getCanvas().setInteractingRenderQuality(
                PPaintContext.HIGH_QUALITY_RENDERING);
        getCanvas().setDefaultRenderQuality(
                PPaintContext.HIGH_QUALITY_RENDERING);
        getCanvas().setAnimatingRenderQuality(
                PPaintContext.HIGH_QUALITY_RENDERING);

        final PPath rect = PPath.createRectangle(100, 100, 200, 200);
        rect.setPaint(Color.GREEN);
        getCanvas().getLayer().addChild(rect);

        final PText text = new PText(getZoomLevelString());
        rect.addChild(text);

        text.centerFullBoundsOnPoint(rect.getBounds().getCenterX(), rect
                .getBounds().getCenterY());

        getCanvas().getCamera().addPropertyChangeListener(
                PCamera.PROPERTY_VIEW_TRANSFORM, new PropertyChangeListener() {
                    public void propertyChange(final PropertyChangeEvent evt) {
                        text.setText(getZoomLevelString());

                        if (getCanvas().getCamera().getViewScale() > 0.9) {
                            rect.setPaint(Color.GREEN);
                        } else {
                            rect.setPaint(Color.RED);
                        }
                    }
                });
    }

    private String getZoomLevelString() {
        return "Zoom level:"
                + String.format("%.2f", getCanvas().getCamera().getViewScale());
    }

    public static void main(final String[] args) {
        new TestRectZoom();
    }
}
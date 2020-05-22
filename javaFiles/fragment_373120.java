package webscale;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebView;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WebScale extends JApplet {
    static ZoomingPane zoomingPane;
    private static JFXPanel fxContainer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JFrame frame = new JFrame("JavaFX 2 in Swing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new WebScale();
                applet.init();

                frame.setContentPane(applet.getContentPane());

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                applet.start();

                frame.addComponentListener(new java.awt.event.ComponentAdapter() {
                    @Override
                    public void componentResized(java.awt.event.ComponentEvent evt) {
                        if (zoomingPane != null) {
                            zoomingPane.setZoomFactors((double)(frame.getWidth()/ 1280.0), (double)(frame.getHeight() / 800.0));
                        }
                    }
                });
            }
        });
    }

    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(300, 200));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                createScene();
            }
        });
    }

    private void createScene() {
        WebView webView = new WebView();
        zoomingPane = new ZoomingPane(webView);
        BorderPane bp = new BorderPane();
        bp.setCenter(zoomingPane);
        fxContainer.setScene(new Scene(bp));
        webView.getEngine().load("http://google.pl");
    }

    private class ZoomingPane extends Pane {
        Node content;
        private final DoubleProperty zoomFactor = new SimpleDoubleProperty(1);
        private double zoomFactory = 1.0;

        private ZoomingPane(Node content) {
            this.content = content;
            getChildren().add(content);
            final Scale scale = new Scale(1, 1);
            content.getTransforms().add(scale);

            zoomFactor.addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    scale.setX(newValue.doubleValue());
                    scale.setY(zoomFactory);
                    requestLayout();
                }
            });
        }

        @Override
        protected void layoutChildren() {
            Pos pos = Pos.TOP_LEFT;
            double width = getWidth();
            double height = getHeight();
            double top = getInsets().getTop();
            double right = getInsets().getRight();
            double left = getInsets().getLeft();
            double bottom = getInsets().getBottom();
            double contentWidth = (width - left - right)/zoomFactor.get();
            double contentHeight = (height - top - bottom)/zoomFactory;
            layoutInArea(content, left, top,
                    contentWidth, contentHeight,
                    0, null,
                    pos.getHpos(),
                    pos.getVpos());
        }

        public final Double getZoomFactor() {
            return zoomFactor.get();
        }
        public final void setZoomFactor(Double zoomFactor) {
            this.zoomFactor.set(zoomFactor);
        }
        public final void setZoomFactors(Double zoomFactorx, Double Zoomfactory) {
            this.zoomFactory = Zoomfactory;
            this.zoomFactor.set(zoomFactorx);
        }

        public final DoubleProperty zoomFactorProperty() {
            return zoomFactor;
        }
    }
}
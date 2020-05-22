import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LwjglFrame extends JFrame{

    private final Canvas canvas;
    private LwjglApplication app;

    public LwjglFrame(final ApplicationListener listener, final LwjglApplicationConfiguration config) {
        canvas = new Canvas(){
            public final void addNotify () {
                super.addNotify();
                app = new LwjglApplication(listener, config, canvas);
            }

            public final void removeNotify () {
                app.stop();
                super.removeNotify();
            }
        };
        canvas.setIgnoreRepaint(true);
        canvas.setFocusable(true);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(canvas, BorderLayout.CENTER);
        setPreferredSize(new Dimension(config.width, config.height));
        pack();
    }

    public LwjglFrame(final ApplicationListener listener, final boolean useGL2) {
        canvas = new Canvas(){
            public final void addNotify () {
                super.addNotify();
                app = new LwjglApplication(listener, useGL2, canvas);
            }

            public final void removeNotify () {
                app.stop();
                super.removeNotify();
            }
        };
        canvas.setIgnoreRepaint(true);
        canvas.setFocusable(true);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(canvas, BorderLayout.CENTER);
    }

}
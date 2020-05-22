import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class CanvasView extends View {
    private ArrayList<Shape> shapes;

    public CanvasView (Context c) {
        super(c);
        init ();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super (context, attrs);
        init ();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
        init ();
    }

    private void init () {
        shapes = new ArrayList<> ();
    }

    @Override
    protected void onDraw (Canvas c) {
        super.onDraw (c);
        for (Shape s : shapes) {
            s.draw (c);
        }
    }

    public void addShape (Shape s) {
        shapes.add (s);
    }

    public void clear () {
        shapes.clear ();
    }
}
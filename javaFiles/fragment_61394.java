import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Scale;
import me.mazeika.dengine.editor.input.Mouse;

import java.util.List;

public class ScrollTransformer implements Transformer
{
    private static final int MAX_SCALE_LEVELS = 80;

    private int scaleLevel = 30;

    @Override
    public void update(Canvas canvas, Affine transform, long now, long delta)
    {
        List<Integer> pendingScrolls = Mouse.getAndRemovePendingScrolls();

        if (! pendingScrolls.isEmpty())
        {
            Point2D pivot = Mouse.getTransformedPosition();

            for (int direction : pendingScrolls)
            {
                boolean up = direction > 0;

                if (! up && scaleLevel == 0 || up && scaleLevel == MAX_SCALE_LEVELS) continue;

                scaleLevel += up ? 1 : -1;

                Scale scale = new Scale(1.1, 1.1, pivot.getX(), pivot.getY());

                if (up)
                {
                    transform.append(scale);
                }
                else
                {
                    try
                    {
                        transform.append(scale.createInverse());
                    }
                    catch (NonInvertibleTransformException e)
                    {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }
}
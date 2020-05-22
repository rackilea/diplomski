import java.awt.*;
import javax.swing.*;

public class PFrame extends JFrame
{
private Rectangle maxBounds;

public PFrame()
{
    super();        
    maxBounds = null;
}

//Full implementation has other JFrame constructors

public Rectangle getMaximizedBounds()
{
    return(maxBounds);
}

public synchronized void setMaximizedBounds(Rectangle maxBounds)
{
    this.maxBounds = maxBounds;
    super.setMaximizedBounds(maxBounds);
}

public synchronized void setExtendedState(int state)
{       
    if (maxBounds == null &&
        (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH)
    {
        Insets screenInsets = getToolkit().getScreenInsets(getGraphicsConfiguration());         
        Rectangle screenSize = getGraphicsConfiguration().getBounds();
        Rectangle maxBounds = new Rectangle(screenInsets.left + screenSize.x, 
                                    screenInsets.top + screenSize.y, 
                                    screenSize.x + screenSize.width - screenInsets.right - screenInsets.left,
                                    screenSize.y + screenSize.height - screenInsets.bottom - screenInsets.top);
        super.setMaximizedBounds(maxBounds);
    }

    super.setExtendedState(state);
}
}
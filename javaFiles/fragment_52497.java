/**
* Controller.java
*/
import java.util.Observable;
import java.util.Observer;

public class Controller
{
/**
 * The controller's inner classes are to be notified of mouse events.
 */
public Controller(Mouse mouse)
{
    mouse.addObserver(new LeftClickObserver());
    mouse.addObserver(new ScrollUpObserver());
}

private class LeftClickObserver implements Observer
{

    @Override
    public void update(Observable o, Object arg)
    {
        // TODO Handle left clicks

    }

    // Other left click logic here
    // ...
}

private class ScrollUpObserver implements Observer
{

    @Override
    public void update(Observable o, Object arg)
    {
        // TODO Handle scroll up

    }

    // Other scroll up logic here
    // ...
}
}
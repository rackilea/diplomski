import java.util.EventListener;
import java.util.EventObject;

public class InputEvent extends EventObject {

    private final String text;

    public InputEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public String getText() {
        return text;
    }

}

public interface InputObsever extends EventListener {

    public void inputChanged(InputEvent evt);

}
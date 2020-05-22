import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Label;

public class UiConstructorTest extends Label {

    public UiConstructorTest() {
        setText("default constructor");
    }

    @UiConstructor
    public UiConstructorTest(String text) {
        setText(text);
    }
}
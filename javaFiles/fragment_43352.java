import javafx.scene.control.TextField;

public class AttributeTextField extends TextField{

    public AttributeTextField() {
        setMinWidth(25);
        setMaxWidth(25);
    }

    public void replaceText(int start, int end, String text) {
        String oldValue = getText();
        if (!text.matches("[A-Za-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            super.replaceText(start, end, text);
        }
        if (getText().length() > 2 ) {
            setText(oldValue);
        }
    }

    public void replaceSelection(String text) {
        String oldValue = getText();
        if (!text.matches("[A-Za-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            super.replaceSelection(text);
        }
        if (getText().length() > 2 ) {
            setText(oldValue);
        }
    }
}
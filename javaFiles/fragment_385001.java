public interface TextView {

    public void setText(String text);
    public String getText();
    public void addTextViewObserver(TextViewObserver observer);
    public void removeTextViewObserver(TextViewObserver observer);

}

public interface TextViewObserver {
    public void textWasChanged(TextView view);
}
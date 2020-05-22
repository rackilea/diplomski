public class TextSaver implements Runnable
{
    private final JTextArea textArea;
    private final ObjectToSaveText saveHere;

    public TextSaver(JTextArea textArea, ObjectToSaveText saveHere)
    {
        this.textArea = textArea;
        this.saveHere = saveHere;
    }

    @Override
    public void run()
    {
        saveHere.save(textArea.getText());
    }
}
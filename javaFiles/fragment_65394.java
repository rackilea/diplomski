public class TextComponentLogger implements ActivityLogger{
    private final JTextComponent target;
    public TextComponentLogger(JTextComponent target) {
        this.target = target;
    }

    public void logAction(final String message){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                target.setText(String.format("%s%s%n", 
                                             target.getText(),
                                             message));
            }
        });
    }
}
// Usage:
JTextArea logView = new JTextArea();
TextComponentLogger logger = new TextComponentLogger(logView);
FileLoader fileLoader = new FileLoader(logger);
fileLoader.loadFile();
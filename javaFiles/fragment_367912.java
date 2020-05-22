public class StreamReaderWorker extends SwingWorker<Object, String> {

    private JTextPane field;

    public StreamReaderWorker(JTextPane field) {
        this.field = field;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String chunk : chunks) {
            try {
                field.getStyledDocument().insertString(1, "chunk", null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected String doInBackground() throws Exception {
        boolean recvread = true;
        while (recvread) {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            try {
                publish("hellooo");
            } catch (IOException e) {
            }
        }
        return null;
    }
}
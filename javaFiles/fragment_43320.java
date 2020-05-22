private static class InputHandler extends Thread {

    private final InputStream is;

    private final ByteArrayOutputStream os;

    public InputHandler(InputStream input) {
        this.is = input;
        this.os = new ByteArrayOutputStream();
    }

    public void run() {
        try {
            int c;
            while ((c = is.read()) != -1) {
                os.write(c);
            }
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public String getOutput() {
        try {
        os.flush();
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
        return os.toString();
    }

}
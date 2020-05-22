public void write(final int i) throws IOException {
    Platform.runLater(new Runnable() {
        public void run() {
            output.appendText(String.valueOf((char) i));
        }
    });
}
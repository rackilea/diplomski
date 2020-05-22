class SentenceProcessorThread extends Thread {
    private String sentence;

    public SentenceProcessorThread(String sentence) {
        this.sentence = sentence;
    }

    public void run() {
        try {
            // your sentence processing logic goes here
        } catch (InterruptedException x) {
        }
    }
}
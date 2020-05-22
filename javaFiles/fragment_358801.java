// Split the document in sentences
ArrayList<String> sentences = tpr.documentToSentences(document);

for (int i = 0; i < sentences.size(); i++) {
    SentenceProcessorThread sentenceProcessorThread = new SentenceProcessorThread(sentences.get(i));
    sentenceProcessorThread.start();
    try {
        sentenceProcessorThread.join(120000); // your timeout period goes here
        if (sentenceProcessorThread.isAlive()) {
            sentenceProcessorThread.interrupt();
            System.out.println("aborting thread");
        }
    } catch (InterruptedException x) {
    }
}
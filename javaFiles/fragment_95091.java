public class KeyPressedSpeechClassifier extends BaseDataProcessor {

    static KeyPressedSpeechClassifier _instance;
    public static KeyPressedSpeechClassifier getInstance() {return _instance;}

    LinkedList<Data> queue;

    volatile boolean isRecognitionEnabled = false;

    public KeyPressedSpeechClassifier() {
        queue = new LinkedList<Data>();
        _instance = this;
        System.out.println("KeyPressedSpeechClassifier created");
    }

    @Override
    public Data getData() throws DataProcessingException {
        Data data = getPredecessor().getData();
        if (data instanceof DoubleData) {
            DoubleData dd = (DoubleData) data;
            queue.push(new SpeechClassifiedData(dd, isRecognitionEnabled));
        } else if (data instanceof SpeechClassifiedData) {
            ((SpeechClassifiedData) data).setSpeech(isRecognitionEnabled);
            queue.push(data);
        } else {
            queue.push(data);
        }
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.pop();
        }
    }

    public void setRecognitionEnabled(boolean enabled) {
        this.isRecognitionEnabled = enabled;
    }
}
class TrainingData<T extends Intent> extends Data {

    private T intent;

    public T getIntent() {
        return intent;
    }

    public void setIntent(T intent) {
        this.intent = intent;
    }
    ...
}
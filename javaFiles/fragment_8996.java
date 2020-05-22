final Task<Void> task = new Task<>() {
    @Override
    public Void call() {
        for (int i=0; i<datesAndStudies.length; i++) {
            DoSomething something = new DoSomething();
            something.progressProperty().addListener(
                (obs, oldProgress, newProgress) -> updateProgress(...));
            something.veryLongAndTimeConsumingMethod();
        }
    }
}
final Task<Void> task = new Task<Void>() {
    @Override
    public Void call() {
        for (int i=0; i<datesAndStudies.length; i++) {
            veryLongAndTimeConsumingMethod(i);
        }
        return null ;
    }

    private void veryLongAndTimeConsumingMethod(int i) {
        // do whatever...
        updateProgress(...);
    }
};
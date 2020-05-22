protected ObservableList<XYChart.Data<Number, Number>> call() throws Exception {
    for (int i = 0; i < 100; i++) {
        if (isCancelled()) {
            break;
        }
        final Double latency = Math.random() * 100;
        final Integer count = i;
        Platform.runLater(() -> {
            partialResults.get().add(new XYChart.Data<>(count, latency));
            System.out.println("adding new Data:" +count +":" + latency);
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(PartialResultsTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateProgress(i, 100);
        //didn't make a change
        //updateValue(getPartialResults());
    }
    return partialResults.get();
}
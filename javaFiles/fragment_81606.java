fxTransactionLog.setRowFactory(tv -> {
    TableRow<Trade> row = new TableRow<>();
    Timeline flasher = new Timeline(

        new KeyFrame(Duration.seconds(0.5), e -> 
            row.pseudoClassStateChanged(flashHighlight, true)),

        new KeyFrame(Duration.seconds(1.0), e -> 
            row.pseudoClassStateChanged(flashHighlight, false))
    );

    flasher.setCycleCount(Animation.INDEFINITE);

    ChangeListener<Boolean> cautionListener = (obs, cautionWasSet, cautionIsNowSet) -> {
        if (cautionIsNowSet) {
            flasher.play();
        } else {
            flasher.stop();
            row.pseudoClassStateChanged(flashHighlight, false);
        }
    };

    cell.itemProperty().addListener((obs, oldItem, newItem) -> {
        if (oldItem != null) {
            oldItem.cautionProperty().removeListener(cautionListener);
        }
        if (newItem == null) {
            flasher.stop();
            row.pseudoClassStateChanged(flashHighlight, false);
        } else {
            newItem.cautionProperty().addListener(cautionListener);
            if (newItem.cautionProperty().get()) { //<-- PROBLEM 3
                flasher.play();
            } else {
                flasher.stop();
                row.pseudoClassStateChanged(flashHighlight, false);
            }
        }
    });
    return row ;
});
someBooleanProperty.addListener((obs, oldValue, newValue) -> {
    if (newValue) {
        flasher.play();
    } else {
        flasher.stop();
        flashingNode.pseudoClassStateChanged(false);
    }
});
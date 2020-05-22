private void initMapListeners() {
    map.addListener((MapChangeListener.Change<? extends ModuleType, ? extends Boolean> change) -> {
        if (change.wasAdded()) {
            if (change.getKey() == ModuleType.TYPEA) {
                checkBoxA.setSelected(change.getValueAdded());
            } else if (change.getKey() == ModuleType.TYPEB) {
                checkBoxB.setSelected(change.getValueAdded());
            }
        }
    });
}
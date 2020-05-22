ObservableList<StringContainer> items = table.getItems();

// initialize counts (only needed once, and only if items is non-empty):
int on = off = unk = 0 ;
for (StringContainer item : items) {
    if ("online".equals(item.getState())) on++ ;
    if ("offline".equals(item.getState())) off++ ;
    if ("unknown".equals(item.getState())) unk++ ;
}

IntegerProperty onCount = new SimpleIntegerProperty(on);
IntegerProperty offCount = new SimpleIntegerProperty(off);
IntegerProperty unknownCount = new SimpleIntegerProperty(unk);

onLbl.textProperty().bind(onCount.asString("Online: %s"));
offLbl.textProperty().bind(offCount.asString("Offline: %s"));
unLbl.textProperty().bind(unknownCount.asString("Unknown: %s"));

ChangeListener<String> listener = (obs, oldValue, newValue) -> {
    if ("online".equals(oldValue)) onCount.set(onCount.get() - 1);
    if ("offline".equals(oldValue)) offCount.set(offCount.get() - 1);
    if ("unknown".equals(oldValue)) unknownCount.set(unknownCount.get() - 1);
    if ("online".equals(newValue)) onCount.set(onCount.get() + 1);
    if ("offline".equals(newValue)) offCount.set(offCount.get() + 1);
    if ("unknown".equals(newValue)) unknownCount.set(unknownCount.get() + 1);
};

items.forEach(item -> item.stateProperty().addListener(listener));

items.addListener((ListChangeListener.Change<? extends StringContainer> c) -> {
    while (c.next()) {
        if (c.wasAdded()) {
            for (StringContainer item : c.getAddedSubList()) {
                item.stateProperty().addListener(listener);
                if ("online".equals(item.getState())) onCount.set(onCount.get() + 1) ;
                if ("offline".equals(item.getState())) offCount.set(offCount.get() + 1)  ;
                if ("unknown".equals(item.getState())) unknownCount.set(unknownCount.get() + 1)  ;

            }
        }
        if (c.wasRemoved()) {
            for (StringContainer item : c.getRemoved()) {
                item.stateProperty().removeListener(listener);
                if ("online".equals(item.getState())) onCount.set(onCount.get() - 1) ;
                if ("offline".equals(item.getState())) offCount.set(offCount.get() - 1)  ;
                if ("unknown".equals(item.getState())) unknownCount.set(unknownCount.get() - 1)  ;

            }
        }
    }
});
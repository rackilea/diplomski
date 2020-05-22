col_age.setOnEditCommit(new EventHandler<CellEditEvent>() {
    @Override
    public void handle(CellEditEvent event) {
        Number a = (Number) event.getNewValue();
        ((Persona)event.getTableView().getItems().get(
                event.getTablePosition().getRow()
        )).setAge(a.intValue());
    }
});
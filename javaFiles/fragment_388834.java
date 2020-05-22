final CheckBoxTableCell<Trainee, Boolean> ctCell = new CheckBoxTableCell<>();
final BooleanProperty selected = new SimpleBooleanProperty();
ctCell.setSelectedStateCallback(new Callback<Integer, ObservableValue<Boolean>>() {
    @Override
    public ObservableValue<Boolean> call(Integer index) {
        return selected ;
    }
});
selected.addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasSelected, Boolean isSelected) {
        System.out.println(isSelected);
    }
});
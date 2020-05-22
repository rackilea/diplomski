someColumn.setFieldUpdater(new FieldUpdater<TheObject, String>() {

    @Override
    public void update(int index, TheObject object, String value) {

        object.setSomeValue(value);
        dataGrid.redraw();
    }
});
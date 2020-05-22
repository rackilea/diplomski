update.setFieldUpdater(new FieldUpdater<HikingMeals, String>() {
    @Override
    public void update(int index, HikingMeals object, String value) {
        Window.alert("Pressed");
    }
});
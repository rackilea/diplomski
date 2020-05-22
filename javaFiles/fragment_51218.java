rbtnUTrue.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
    @Override
    public void onValueChange(ValueChangeEvent<Boolean> event) {
        if (rbtnUTrue.isChecked()) {
            dummy_u = 1;
        } else if (rbtnUFalse.isChecked()) {
            dummy_u = 0;
        }
    }
});
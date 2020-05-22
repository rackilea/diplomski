combobox_radio.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
    if (newValue == null) {
        label_rad_substance.setText("");
        label_halftime.setText("");
    } else {
        label_rad_substance.setText(newValue.getSubstance().getName());
        label_halftime.setText(newValue.getSubstance().getHalfLife()+"");
    }
});
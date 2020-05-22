numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            String formated = String.format("%02d", numberPicker.getValue());
            Log.d("PickerValue", formated);
            yourTextView.setText(formated);

        }
    });
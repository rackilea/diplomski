hourPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            Integer value = hourPicker.getValue();

            resultInteger.clear();
            for (int index = 0; index < value; index++) {
                resultInteger.add(index);
            }

            ArrayAdapter<Integer> hourAdapter = new ArrayAdapter<>(YourActivity.this, android.R.layout.simple_spinner_item, resultInteger);
            hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            hourSpinner.setAdapter(hourAdapter);
        }
    });
DatePickerFragment datePickerFragment = new DatePickerFragment();
    datePickerFragment.setDateChangeListener(new DatePickerFragment.DateChangeListener(){
        public void onDateChange(){
            setDate();
        }
    });

    datePickerFragment .show(getSupportFragmentManager(), "datePicker");
}
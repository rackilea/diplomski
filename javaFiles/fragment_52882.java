final DatePickerDialog.OnDateSetListener startListener = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = DateFormat.getDateInstance().format(calendar.getTime());

        // set the start date TextView
        startDatePicker.setText(dateString);
    }
};

final DatePickerDialog.OnDateSetListener endListener = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = DateFormat.getDateInstance().format(calendar.getTime());

        // set the enddate TextView
        endDatePicker.setText(dateString);
    }
};

// NOTE: Use getSupportFragmentManager or getFragmentManager below
//       depending on which type of DialogFragment you extended

// Reset the listener if the screen was rotated
if (savedInstanceState != null) {
    DatePickerDialogFragment dpf;

    dpf = (DatePickerDialogFragment) getSupportFragmentManager().findFragmentByTag("myStartDatePicker");
    if (dpf != null) {
        dpf.setListener(startListener);
    }

    dpf = (DatePickerDialogFragment) getSupportFragmentManager().findFragmentByTag("myEndDatePicker");
    if (dpf != null) {
        dpf.setListener(endListener);
    }
}

startDatePicker.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        DatePickerDialogFragment dpf = new DatePickerDialogFragment();

        // set bundle args on dpf if still needed

        dpf.setListener(startListener);
        dpf.show(getSupportFragmentManager(), "myStartDatePicker");
    }
});

endDatePicker.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        DatePickerDialogFragment dpf = new DatePickerDialogFragment();

        // set bundle args on dpf if still needed

        dpf.setListener(endListener);
        dpf.show(getSupportFragmentManager(), "myEndDatePicker");
    }
});
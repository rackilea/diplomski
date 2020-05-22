// Class member variables
private Calendar myCalendar = Calendar.getInstance();
private boolean birthday_is_set = false;


// this next part is in onCreate

// set the calendar date to a saved date if applicable
// and change birthday_is_set if they had saved a birthday


final DatePickerDialog.OnDateSetListener birthdayListener = new DatePickerDialog.OnDateSetListener() {

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
        // I save the date in a calendar, replace this
        // with whatever you want to do with the selected date
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        birthday_is_set = true;
        updateBirthdayLabel();
    }
};

if (savedInstanceState != null) {
    DatePickerDialogFragment dpf;

    dpf = (DatePickerDialogFragment) getFragmentManager().findFragmentByTag("birthdayDatePicker");
    if (dpf != null) {
        // on rotation the listener will be referring to the old Activity,
        // so we have to reset it here to act on the current Activity
        dpf.setListener(birthdayListener);
    }
}

birthdayDatePicker.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Your logic may vary here. I chose not to start it in year
        // mode if they've already selected a date.
        boolean startInYears = !birthday_is_set;
        DatePickerDialogFragment dpf = DatePickerDialogFragment.newInstance(startInYears, myCalendar);
        dpf.setListener(birthdayListener);
        dpf.show(getFragmentManager(), "birthdayDatePicker");
    }
});
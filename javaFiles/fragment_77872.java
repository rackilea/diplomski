public static class DatePickerFragment extends DialogFragment
                            implements DatePickerDialog.OnDateSetListener {

    public static DatePickerFragment newInstance(int year,int month,int day) {
        Bundle b = new Bundle();
        b.putInt("year", year);
        // put others...

        Fragment f = new DatePickerFragment();
        f.setArguments(b);
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Update using the arguments
        Bundle args = getArguments();
        if (args != null) {
            year = args.getInt("year");
            // get others...
        }

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
    }
}
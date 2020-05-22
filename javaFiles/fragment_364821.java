public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "DatePickerFragment";

    private SimpleDateFormat dateFormatterEntry = new SimpleDateFormat("M/dd/yyyy");
    private Calendar calendar;
    int year;
    int month;
    int day;

    private DatePickedListener listener;

    public static interface DatePickedListener {
        void onDatePicked(String date);
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.i(TAG, "onCreateDialog");

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        listener = (DatePickedListener) getActivity();

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        calendar.set(year, month, day, 0, 0);
        String formattedDate = dateFormatterEntry.format(calendar.getTime());
        Log.i(TAG, formattedDate);
        listener.onDatePicked(formattedDate);
    }
}
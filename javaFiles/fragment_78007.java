public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    TextView textView;
    Context context;
    private TimePickerDialog timePickerDialog;

    public TimePicker(EditText text, Context context) {
        this.text= textView;
        this.context = context;
    }

    public TimePicker() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        Time t = new Time(hourOfDay,minute,0);//seconds by default set to zero
        Format formatter;
        formatter = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        String time = formatter.format(t);
          textView.setText(hourOfDay+":"+minute);
    }

}
public class TimePicker_Fragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private static final String KEY_TIMEPICKER_TAG = "KEY_TIMEPICKER_TAG";

    /**
     *
     * @param timePickerTag the tag by which you can identify a TimePicker.  
     *             Will be set as tag to the TimePicker View in onTimeSet()
     * @return x
     */
    public static TimePicker_Fragment instance(String timePickerTag){
        TimePicker_Fragment fragment = new TimePicker_Fragment();
        Bundle b = new Bundle();
        b.putString(KEY_TIMEPICKER_TAG, timePickerTag);
        fragment.setArguments(b);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        Context ctx = getContext();
        return new TimePickerDialog(ctx, this, hour, minute, DateFormat.is24HourFormat(ctx));
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2){
        Bundle b = getArguments();
        assert b != null;
        timePicker.setTag(b.getString(KEY_TIMEPICKER_TAG));
        ((TimePickerDialog.OnTimeSetListener)getActivity()).onTimeSet(timePicker, i, i2);
    }
}
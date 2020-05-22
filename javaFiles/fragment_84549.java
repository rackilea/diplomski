public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private static final String ARGS_TAG = "ARGS_TAG";

    public static TimePickerFragment newInstance(String tag) {
        Bundle args = new Bundle();
        args.putString(ARGS_TAG, tag);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(requireActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        final String tag = getArguments().getString(ARGS_TAG);
        OnTimeSetListener listener = (OnTimeSetListener) requireActivity();
        listener.onTimeSet(tag, view, hourOfDay, minute);
    }
}
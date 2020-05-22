public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private static final String ARGUMENT_TAG = "ARGUMENT_TAG";

    public static DatePickerFragment newInstance(String tag) {
        Bundle args = new Bundle();
        args.putString(ARGUMENT_TAG, tag);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(requireActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final String tag = getArguments().getString(ARGUMENT_TAG);
        OnDateSetListener listener = (OnDateSetListener) requireActivity();
        listener.onDateSet(tag, view, year, month, dayOfMonth);
    }
}
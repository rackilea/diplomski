public class DatePickerDialogFragment extends DialogFragment {

    private DatePickerDialog.OnDateSetListener listener = null;

    void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    private static final String START_IN_YEARS = "com.myapp.picker.START_IN_YEARS";
    private static final String YEAR = "com.myapp.picker.YEAR";
    private static final String MONTH = "com.myapp.picker.MONTH";
    private static final String DAY_OF_MONTH = "com.myapp.picker.DAY_OF_MONTH";

    public static DatePickerDialogFragment newInstance(boolean startInYears, Calendar c) {
        DatePickerDialogFragment f = new DatePickerDialogFragment();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Bundle args = new Bundle();
        args.putBoolean(START_IN_YEARS, startInYears);
        args.putInt(YEAR, year);
        args.putInt(MONTH, month);
        args.putInt(DAY_OF_MONTH, day);

        f.setArguments(args);
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle args = getArguments();
        DatePickerDialog dpd = null;

        if( listener != null && args != null) {
            boolean startInYears = args.getBoolean(START_IN_YEARS);

            Context context = getActivity();
            boolean requireSpinnerMode = isBrokenSamsungDevice();
            if (requireSpinnerMode) {
                context = new ContextThemeWrapper(context, android.R.style.Theme_Holo_Light_Dialog);
            }

            int year = args.getInt(YEAR);
            int month = args.getInt(MONTH);
            int day = args.getInt(DAY_OF_MONTH);

            dpd = new DatePickerDialog(context, listener, year, month, day);

            if (startInYears && !requireSpinnerMode) {
                boolean canOpenYearView = openYearView(dpd.getDatePicker());
                if (!canOpenYearView) {
                    context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Light_Dialog);
                    dpd = new DatePickerDialog(context, listener, year, month, day);
                }
            }
        }
        else {
            setShowsDialog(false);
            dismissAllowingStateLoss();
        }

        return dpd;
    }

    private static boolean isBrokenSamsungDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") &&
                isBetweenAndroidVersions(
                        Build.VERSION_CODES.LOLLIPOP,
                        Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    private static boolean isBetweenAndroidVersions(int min, int max) {
        return Build.VERSION.SDK_INT >= min && Build.VERSION.SDK_INT <= max;
    }

    private static boolean openYearView(DatePicker datePicker) {
        if( isBrokenSamsungDevice() ) {
            return false;
        }

        View v = datePicker.findViewById(Resources.getSystem().getIdentifier("date_picker_header_year", "id", "android"));
        if( v != null ) {
            v.performClick();
        }
        else {
            try {
                Field mDelegateField = datePicker.getClass().getDeclaredField("mDelegate");
                mDelegateField.setAccessible(true);
                Object delegate = mDelegateField.get(datePicker);
                Method setCurrentViewMethod = delegate.getClass().getDeclaredMethod("setCurrentView", int.class);
                setCurrentViewMethod.setAccessible(true);
                setCurrentViewMethod.invoke(delegate, 1);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
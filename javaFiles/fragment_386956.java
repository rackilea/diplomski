public class TimepickerActivity extends Activity implements TimePickerDialog.OnTimeSetListener {

    private static final int SUB_HOUR = -7;
    private static final int SUB_MINUTE = -30;

    [...]

public void onTimeSet(TimePicker view, int selectedHour,
        int selectedMinute) {

    // Gets current time
    Calendar c = Calendar.getInstance();

    // Assign hour set in the picker
    c.set(Calendar.HOUR, selectedHour)
    c.set(Calendar.MINUTE, selectedMinute);

    // Have Calendar calculate the substraction of hours and minutes
    c.add(Calendar.HOUR, SUB_HOUR);
    c.add(Calendar.MINUTE, SUB_MINUTE);

    // Get the hour and the minute calculated
    hour = c.get(Calendar.HOUR);
    minute = c.get(Calendar.MINUTE);
    [...]
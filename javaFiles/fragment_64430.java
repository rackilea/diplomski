public void setTime(View v) {
    if (mCurrentReminderUri == null) {
        Toast.makeText(this, "click again on the reminder list to set time alarm", Toast.LENGTH_LONG).show();
        return;
    }
    Calendar now = Calendar.getInstance();
    TimePickerDialog tpd = new TimePickerDialog(this, null,
            now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false);
    tpd.show();
}

// On clicking Date picker
public void setDate(View v) {
    if (mCurrentReminderUri == null) {
        Toast.makeText(this, "click again on the reminder list to set date alarm", Toast.LENGTH_LONG).show();
        return;
    }
    Calendar now = Calendar.getInstance();
    DatePickerDialog dpd = new DatePickerDialog (this, null, now.get(Calendar.YEAR),
            now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
    dpd.show();
}
public class AddEventActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    ...
    boolean isSettingStartTime = true;


    //code ommitted for length

    public void showTimePickerDialog(View v) {
        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        ...

        if (isSettingStartTime) {
            startTimeView.setText(pickerHour + " : " + minutesString + pickerMin + " " +amOrPm );
            isSettingStartTime = false;
        } else {
            endTimeView.setText(pickerHour + " : " + minutesString + pickerMin + " " +amOrPm );
        }
    }
}
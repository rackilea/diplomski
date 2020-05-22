public class MainActivity extends Activity {

        TextView resultText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            resultText = (TextView)findViewById(R.id./*YOUR TEXT VIEW ID*/);
        }

        //code from: http://developer.android.com/guide/topics/ui/controls/pickers.html
        public void showTimePicker(View v) {
            DialogFragment newFragment = new TimePickerFragment(resultText);
            newFragment.show(getFragmentManager(), "timePicker");
        }

        public class TimePickerFragment extends DialogFragment
                implements TimePickerDialog.OnTimeSetListener {

             TextView mResultText;

             public TimePickerFragment(TextView textView) {
                mResultText = textView;
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

            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = /*CONVERT YOUR TIME FROM hourOfDay and minute*/;
                mResultText.setText(time);
            }
        }
    }
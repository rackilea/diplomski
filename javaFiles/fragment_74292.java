public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Get a Calendar instance
        final Calendar calendar = Calendar.getInstance();
        // Get the current hour and minute
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // TimePickerDialog Theme : THEME_DEVICE_DEFAULT_LIGHT
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_DEVICE_DEFAULT_DARK
        TimePickerDialog tpd2 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_HOLO_DARK
        TimePickerDialog tpd3 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_DARK,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_HOLO_LIGHT
        TimePickerDialog tpd4 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_LIGHT,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_TRADITIONAL
        TimePickerDialog tpd5 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_TRADITIONAL,this,hour,minute,false);

        // Return the TimePickerDialog
        return tpd;      //return your themed timepicker like tpd2, tpd3 etc..
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        // Do something with the returned time
        TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        tv.setText("HH:MM\n" + hourOfDay + ":" + minute);
    }
}
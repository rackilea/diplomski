editText = (EditText)findViewById(R.id.editText);
    editText2 = (EditText)findViewById(R.id.editText2);
    editText3 = (EditText)findViewById(R.id.editText3);

    editText2.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
        @Override
        public void onFocusChange(View v, boolean hasFocus)
        {
            String input;
            EditText editText;

            if(!hasFocus)
            {
                TimePick time = new TimePick(v);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                time.show(ft, "TimePicker");
            }
        }
    });


    editText2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TimePick time = new TimePick(v);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            time.show(ft, "TimePicker");
        }
    });
}

public class TimePick extends DialogFragment implements TimePickerDialog.OnTimeSetListener
{
    private TextView time;

    public TimePick(View view)
    {
        time=(EditText)view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Calendar c= Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        //Toast.makeText(getActivity(),this,"Date: "+year+"-",+month+"-"+day,Toast.LENGTH_SHORT).show();
        return new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));
    }
    public void onTimeSet(TimePicker view,int hourofDay, int minute)
    {
        time.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
    }
}
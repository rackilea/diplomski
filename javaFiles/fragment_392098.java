public class Leave extends AppCompatActivity {

TextView date;
private DatePickerDialog datePickerDialog;
TextView date2;
//TextView setDay;
private DatePickerDialog datePickerDialog2;
TextView no_of_days;
String date1 = "", date2 = "";


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_leave);

    date = (TextView) findViewById(R.id.date);
    date2 = (TextView) findViewById(R.id.date2);
    //setDay = (TextView) findViewById(R.id.setDay);
    no_of_days = (TextView) findViewById(R.id.no_of_days);
    RadioButton radio_full = (RadioButton) findViewById(R.id.radio_full);
    RadioButton radio_Half = (RadioButton) findViewById(R.id.radio_Half);
    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioleave);
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int buttonId = radioGroup.getCheckedRadioButtonId();
            switch (buttonId) {
                case R.id.radio_full:
                    Toast.makeText(getApplicationContext(), "You have selected Full Day Leave", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radio_Half:
                    Toast.makeText(getApplicationContext(), "You have selected Half Day Leave", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    });

    // initially hide the radio buttons
    radio_full.setVisibility(View.GONE);
    radio_Half.setVisibility(View.GONE);

    // initiate the date picker and a button
    date = (TextView) findViewById(R.id.date);
    // perform click event on edit text
    date.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // calender class's instance and get current date , month and year from calender
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR); // current year
            int mMonth = c.get(Calendar.MONTH); // current month
            int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
            // date picker dialog
            datePickerDialog = new DatePickerDialog(Leave.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text
                            // assign the value to date1
                            date1 = dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year;

                            date.setText(dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year);

                            // check if date2 has been set and compare it with date1
                            if(!TextUtils.isEmpty(date2)) {

                                // get difference
                                getDifferenceDays(date, date2);

                                if(date1.equals(date2)) {
                                    // pop up radio button
                                   radio_full.setVisibility(View.VISIBLE);
                                   radio_Half.setVisibility(View.VISIBLE);
                                } else {
                                   // hide radio buttons
                                   radio_full.setVisibility(View.GONE);
                                   radio_Half.setVisibility(View.GONE);
                                }
                            }

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    });

    // initiate the date picker and a button
    date2 = (TextView) findViewById(R.id.date2);
    // perform click event on edit text
    date2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // calender class's instance and get current date , month and year from calender
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR); // current year
            int mMonth = c.get(Calendar.MONTH); // current month
            int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
            // date picker dialog
            datePickerDialog2 = new DatePickerDialog(Leave.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text

                            // assign the value to date2
                            date2 = dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year;

                            date2.setText(dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year);
                            // check if date2 has been set and compare it with date1
                            if(!TextUtils.isEmpty(date1)) {

                                // get difference
                                getDifferenceDays(date, date2);

                                if(date1.equals(date2)) {
                                   // pop up radio button
                                   radio_full.setVisibility(View.VISIBLE);
                                   radio_Half.setVisibility(View.VISIBLE);
                                } else {
                                   // hide radio buttons
                                   radio_full.setVisibility(View.GONE);
                                   radio_Half.setVisibility(View.GONE);
                                }  
                            }

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog2.show();

        }
    });

    no_of_days.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            String date01 = date.getText().toString();
            String date02 = date2.getText().toString();
            try {
                Date d = format.parse(date01);
                Date d1 = format.parse(date02);
                getDifferenceDays(d, d1);
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
    });

    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.leave_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
   // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
}
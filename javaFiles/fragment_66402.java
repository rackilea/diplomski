private TextView reservation;

RadioButton chcOne;
RadioButton chcTwo;
RadioButton chcThree;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    reservation = (TextView) findViewById(R.id.rsltText);
    Button btnDate = (Button) findViewById(R.id.btnDate);
    chcOne = (RadioButton) findViewById(R.id.choiceOne);
    chcTwo = (RadioButton) findViewById(R.id.choiceTwo);
    chcThree = (RadioButton) findViewById(R.id.choiceThree);

    btnDate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new DatePickerDialog(MainActivity.this, date, cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
        }
    });

}

Calendar cal = Calendar.getInstance();
DateFormat fmtDate = DateFormat.getDateInstance();
DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, monthOfYear);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        if (chcOne.isChecked()) {
            reservation.setText("A Massive Asteroid Will Impact The Earth on "
                    + fmtDate.format(cal.getTime()));
        } else {Toast.makeText(MainActivity.this, "Choose Something!",Toast.LENGTH_LONG).show();
        }
        if (chcTwo.isChecked()){
            reservation.setText("Massive Tsunamis Will Engulf The World on "
                    + fmtDate.format(cal.getTime()));
        } else {Toast.makeText(MainActivity.this, "Choose Something!",Toast.LENGTH_LONG).show();
        }
        if (chcThree.isChecked()) {
            reservation.setText("A Fatal Disease Will OverWhelm The World on "
                    + fmtDate.format(cal.getTime()));
        } else {Toast.makeText(MainActivity.this, "Choose Something!",Toast.LENGTH_LONG).show();
        }
    }
};
}
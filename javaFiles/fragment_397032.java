@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.citations);
    final Button citationButton = (Button) findViewById(R.id.button10);

    editText1 = (EditText) findViewById(R.id.editText1);
    editText2 = (EditText) findViewById(R.id.editText2);
    author = (EditText) findViewById(R.id.author);
    articleTitle = (EditText) findViewById(R.id.articleTitle);
    webTitle = (EditText) findViewById(R.id.webTitle);
    webDay = (EditText) findViewById(R.id.webDay);
    webMonth = (EditText) findViewById(R.id.webMonth);
    webYears = (EditText) findViewById(R.id.webYears);
    final  TextView citationText = (TextView) findViewById(R.id.textView10);


    citationButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Calendar cal = Calendar.getInstance();
            // Gets date from the calendar!
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);

            String month1 = String.valueOf(month);
            String day1 = String.valueOf(day);
            String year1 = String.valueOf(year);

            String authorFirst1 = editText1.getText().toString();
            String authorLast1 = author.getText().toString();
            String articleTitle1 = articleTitle.getText().toString();
            String website1 = webTitle.getText().toString();
            String Publisher1 = editText2.getText().toString();
            String month2 = webMonth.getText().toString();
            String day2 = webDay.getText().toString();
            String year2 = webYears.getText().toString();
            String Total = authorLast1+","+" "+authorFirst1+"."+" "+"\""+articleTitle1+"."+"\""+" "+website1+"."+" "+Publisher1+","+" "+day2+" "+month2+" "+year2+"."+" "+"Web"+"."+" "+day+" "+month+"."+" "+year+".";
            citationText.setText(authorFirst1);
        }
    });
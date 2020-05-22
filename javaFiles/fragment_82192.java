Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);

    // display the current date
    String CurrentDate = mYear + "/" + mMonth + "/" + mDay;

    String dateInString = CurrentDate; // Start date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    c = Calendar.getInstance();

    try {
        c.setTime(sdf.parse(dateInString));
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    c.add(Calendar.DATE, 7656);//insert the number of days you want to be added to the current date
    sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date resultdate = new Date(c.getTimeInMillis());
    dateInString = sdf.format(resultdate);

    //Display the Result in the Edit Text or Text View your Choice
    EditText etDOR = (EditText)findViewById(R.id.etDateOfReturn);
    etDOR.setText(dateInString);
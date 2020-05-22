String format = "yyyy-MM-dd";
SimpleDateFormat sdf = new SimpleDateFormat(format);
String dateString = dateButton.getText().toString();
Date date = sdf.parse(dateString);
Calendar myCalendar = Calendar.getInstance();
myCalendar.setTime(date);
new DatePickerDialog(context, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
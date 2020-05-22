new DatePickerDialog(Activityclass.this, date1, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();

DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        view.setMinDate(1559327400);
        y = year;
        m = month;
        d = dayOfMonth;
        dateMonth = month + 1;
        dateYear = year;
        iqp_editDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        try {
            epoch = new java.text.SimpleDateFormat("MM/dd/yyyy").parse(m + "/" + dayOfMonth + "/" + year).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
};
private void DateDialog() {

 final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel();
                    }

                };

                DatePickerDialog dpDialog = new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));

                Toast.makeText(MainActivity.this, "date::"+myCalendar.getTimeInMillis(), Toast.LENGTH_SHORT).show();

                String dt = "2018-04-15";
                String dtSixteen = "2018-04-16";

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                try {
                    Date dateFifteen = format.parse(dt);
                    Calendar calFifteen = Calendar.getInstance();
                    calFifteen.setTime(dateFifteen);

                    Date dateSixteen = format.parse(dtSixteen);
                    Calendar calSixteen = Calendar.getInstance();
                    calSixteen.setTime(dateSixteen);


                    Date currentDate = myCalendar.getTime();
                    Calendar calendar = Calendar.getInstance();

                    calendar.setTime( myCalendar.getTime() );
                    calendar.set(Calendar.HOUR_OF_DAY, 0);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);

                    currentDate = calendar.getTime();


                    if(currentDate.before(dateFifteen) || currentDate.equals(dateFifteen)){
                        dpDialog.getDatePicker().setMaxDate(calFifteen.getTimeInMillis());
                    }else {
                         dpDialog.getDatePicker().setMinDate(calSixteen.getTimeInMillis());
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                dpDialog.show();

}
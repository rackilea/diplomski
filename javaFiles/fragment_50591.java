Calendar calendar=Calendar.getInstance();           
    DatePickerDialog dialog=new DatePickerDialog(this, new OnDateSetListener() {                        

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                            int dayOfMonth) {

                        //your code
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)); 

    dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
    dialog.show();
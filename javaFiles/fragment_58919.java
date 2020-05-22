DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
    new DatePickerDialog.OnDateSetListener() {   
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            txtDate.setText(checkDigit(monthOfYear + 1) + "-" + dayOfMonth  + "-" + year);
            currentDayCal.set(Calendar.DATE,dayOfMonth);
            currentDayCal.set(Calendar.MONTH,monthOfYear + 1);
            currentDayCal.set(Calendar.YEAR,year);
        }
    }, mYear, mMonth, mDay);
    datePickerDialog.show();
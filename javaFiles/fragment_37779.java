private int year, monthOfYear, dayOfMonth;

private void yourMethod() {
  ...
  tv.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          DatePickerDialog datePickerDialog = new DatePickerDialog(CreateLine.this, new DatePickerDialog.OnDateSetListener() {

             @Override
             public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
               monthOfYear = monthOfYear + 1;
               String Sd = String.valueOf(dayOfMonth + "/" + monthOfYear + "/" + year);
               tv.setText(Sd);
             }
}
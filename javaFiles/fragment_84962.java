public void ShowDatePicker() {
        MyDatePicker myTimePicker = new MyDatePicker(this);
        myTimePicker.show();
    myTimePicker.setDateListener(new onDateSet() {

        @Override
        public void onDate(DatePicker view, int year, int monthOfYear,
                int dayOfMonth) {
            Toast.makeText(MainActivity.this,
                    "date is " + year + ":" + monthOfYear+":"+dayOfMonth,
                    Toast.LENGTH_LONG).show();

        }
    });
}
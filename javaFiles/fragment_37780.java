@Override
public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

  // Set the variables value here:
  YourClass.this.year = year;
  YourClass.this.monthOfYear = monthOfYear;
  YourClass.this.dayOfMonth = dayOfMonth;

  monthOfYear = monthOfYear + 1;
  String Sd = String.valueOf(dayOfMonth + "/" + monthOfYear + "/" + year);
  tv.setText(Sd);
}
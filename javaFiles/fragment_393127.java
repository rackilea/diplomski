Calendar calender = Calendar.getInstance();
    myTimePicker = new TimePickerDialog(this, new OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


            Calendar newTime = Calendar.getInstance();

            //newTime.set(hourOfDay, minute); // remove this line

            //Add these two line
            newTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            newTime.set(Calendar.MINUTE, minute);

            GotTime = GotDate + " At " + String.valueOf(hourOfDay) + " :" + String.valueOf(minute + 1);
            time.setText(GotTime);
        }
    }, calender.get((Calendar.HOUR_OF_DAY)), calender.get(Calendar.MINUTE), true);
}
if (flag == FLAG_START_DATE) {
    inHour = hourofDay;
    inMin = minute;
    timeIn.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
    TimeIn = timeIn.getText().toString();
}
else if (flag == FLAG_END_DATE) {
    outHour = hourofDay;
    outMin = minute;
    timeOut.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
    TimeOut = timeOut.getText().toString();
}
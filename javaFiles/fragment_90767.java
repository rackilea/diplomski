final Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int min = c.get(Calendar.MINUTE);
if((flag == FLAG_START_DATE) && inHour != -1 && inMin != -1) 
{
     hour = inHour;
     min = inMin;
}
else if((flag == FLAG_END_DATE) && outHour != -1 && outMin != -1) 
{
     hour = outHour;
     min = outMin;
}

return new TimePickerDialog(getActivity(), this, hour, min, DateFormat.is24HourFormat(getActivity()));
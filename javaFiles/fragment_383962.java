for (int i = 0; i < 7; i++)
{
  week_dates[i] = dateFormat.format(calendar.getTime());
  //calendar.set(Calendar.DAY_OF_WEEK, i);
  calendar.add(Calendar.DATE, 1);
}
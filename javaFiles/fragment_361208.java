private String getCurrentDate()
{
      final DateFormat format = DateFormat.getDateTimeInstance();
      format.setTimeZone(Calendar.getInstance().getTimeZone());
      return format.format(new Date());
}
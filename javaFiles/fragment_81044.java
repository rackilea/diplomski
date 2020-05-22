public static XMLGregorianCalendar setCoverStartDate(Date date) throws DatatypeConfigurationException {
    Calendar calendar = Calendar.getInstance();
    date.setTime(date.getTime());
    return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH) + 1,
        calendar.get(Calendar.DAY_OF_MONTH),
        getTimeZone(calendar));
  }

  public static int getTimeZone(Calendar calendar) {
    return (int) TimeUnit.MINUTES.convert(calendar.get(Calendar.ZONE_OFFSET), TimeUnit.MILLISECONDS);
  }
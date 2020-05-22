Calendar calendar = new GregorianCalendar();
xmlDate = DatatypeFactory.newInstance().newXMLGregoriantCalendar(
    calendar.get(Calendar.YEAR),
    calendar.get(Calendar.MONTH) + 1,
    // etc
    );
GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(date);

    XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH)+1,
            cal.get(Calendar.DAY_OF_MONTH),
            DatatypeConstants.FIELD_UNDEFINED);
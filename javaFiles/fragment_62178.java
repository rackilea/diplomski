private XMLGregorianCalendar dateWithoutTimezone(Date date) throws DatatypeConfigurationException {
    calendar.setTime(date);
    XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
    return xmlGregorianCalendar;
}
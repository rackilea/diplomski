String xml = "2013-08-26T12:00:00.000"; // maybe optionally with additional timezone offset
javax.xml.datatype.DatatypeFactory factory = javax.xml.datatype.DatatypeFactory.newInstance();
XMLGregorianCalendar xmlGregCal = factory.newXMLGregorianCalendar(xml);
java.util.Date d = xmlGregCal.toGregorianCalendar().getTime();

SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String output = outputFormat.format(d);
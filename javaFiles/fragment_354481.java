import javax.xml.bind.DatatypeConverter;

// ...
Calendar cal = Calendar.getInstance();
cal.setTime(new java.util.Date(timeInLong));
System.out.println(DatatypeConverter.printDateTime(cal));
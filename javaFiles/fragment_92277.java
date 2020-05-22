String formattedDate = sdf.format(categoryData.getBulkCollectionTime()); //yyyy-MM-dd HH:mm:ss
convertStringToXmlGregorian(formattedDate);


public XMLGregorianCalendar convertStringToXmlGregorian(String dateString)
{
      try {
            Date date = sdf.parse(dateString);
            GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
            gc.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (ParseException e) {
            // Optimize exception handling
            System.out.print(e.getMessage());
            return null;
        } 

}
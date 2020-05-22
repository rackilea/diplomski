public void convertDate(Date d) {  

    //You are getting server date as argument, parse your server response and then pass date to this method

    SimpleDateFormat sdfAmerica = new SimpleDateFormat("hh:mm:ss");

    String actualTime = sdfAmerica.format(d);
    //Changed timezone
    TimeZone tzInAmerica = TimeZone.getTimeZone("CST");
    sdfAmerica.setTimeZone(tzInAmerica);

    String convertedTime = sdfAmerica.format(d);

    System.out.println("actual : " + actualTime + "  converted " + ConvertedTime);

    return convertedTime;
    }
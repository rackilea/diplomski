String str = "10:12:57 pm";

DateTimeFormatter formatter_from = DateTimeFormatter.ofPattern( "hh:mm:ss a", Locale.US ); //Use pattern symbol "hh" for 12 hour clock
LocalTime localTime = LocalTime.parse(str.toUpperCase(), formatter_from );
DateTimeFormatter formatter_to = DateTimeFormatter.ofPattern( "HH:mm" , Locale.US ); // "HH" stands for 24 hour clock

System.out.println(localTime.format(formatter_to));
String date = "21-04-2013";
SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); // input date
Date outDate = dateFormatter.parse(date);

SimpleDateFormat dayFormatter = new SimpleDateFormat("dd"); // output day
SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM"); // output month
SimpleDateFormat yearFormatter = new SimpleDateFormat("yy"); // output year

String day = dayFormatter.format(outDate);
String monthy = monthFormatter.format(outDate);
String year = yearFormatter.format(outDate);
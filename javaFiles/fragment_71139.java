SimpleDateFormat datefmt = new SimpleDateFormat("MM/dd/yyyy"); // Or format you're using
Date date = datefmt.parse(dates);

Calendar cal = Calendar.getInstance();
cal.setTime(date);
cal.add(Calendar.DAY_OF_MONTH, 30); // Add 30 days
Date futureDate = cal.getTime();
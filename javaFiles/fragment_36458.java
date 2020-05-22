String input = "2009-09-30";
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date myDate = dateFormat.parse(input);
Calendar cal1 = Calendar.getInstance();
cal1.setTime(myDate);
cal1.add(Calendar.DAY_OF_YEAR, -1);
Date previousDate = cal1.getTime();
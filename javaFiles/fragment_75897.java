SimpleDateFormat simpleDateFormatIn =
        new SimpleDateFormat("dd MMMM yyyy '|' HH:mm", Locale.ENGLISH);
SimpleDateFormat simpleDateFormatOut =
        new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

String dateStr = (driver.findElement(By.id("date"))).getText();
Date date = simpleDateFormatIn.parse(dateStr);

System.out.println(simpleDateFormatOut.format(date));
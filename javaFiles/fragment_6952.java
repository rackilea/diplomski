String dateTime ="1993-10-09";
String[] output = dateTime.split("-");
String year = output[0];
String day = output[2];
String[] day1 = day.split("");
WebDriverWait wait = new WebDriverWait(driver, 5);
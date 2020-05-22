String name = file.getName();
String datePortion = /*extract date portion*/;

DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
Date fileDate = fmt.parse(datePortion);
long msBetweenDates = new Date().getTime() - fileDate.getTime();
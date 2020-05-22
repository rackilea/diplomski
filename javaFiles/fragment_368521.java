String endDateValue = "07/01/2013";
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
Date endDate = sdf.parse(endDateValue);

Calendar cal = Calendar.getInstance();
cal.setTime(endDate);
cal.add(Calendar.MONTH, -6);

Date startDate = cal.getTime();
String startDateVaue = sdf.format(startDate);
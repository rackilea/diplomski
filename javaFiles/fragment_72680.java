Calendar c = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
c.setTime(sdf.parse(date));
c.add(Calendar.DATE, -30);
Date newDate = c.getTime();
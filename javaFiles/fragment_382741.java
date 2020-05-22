DateFormat formatter= new SimpleDateFormat("E, d MMM yyyy hh:mm:ss zzz");
Calendar currentDate = Calendar.getInstance();
currentDate.setTime(new Date());
currentDate.add(Calendar.MINUTE, 24);
Date newDate = currentDate.getTime();
System.out.println(formatter.format(newDate));
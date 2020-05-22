SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd hh:mm:ss 'GMT'Z yyyy");
Calendar c = Calendar.getInstance();
c.set(Calendar.YEAR,1754);
c.set(Calendar.MONTH, 0); // JAN
c.set(Calendar.DATE, 1);
System.out.println(sdf.format(new Date(c.getTimeInMillis())));
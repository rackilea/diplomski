SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

Calendar c = Calendar.getInstance();
c.set(year, month, 1); // Specify day of month

String formattedDate = dateFormat.format(c.getTime());
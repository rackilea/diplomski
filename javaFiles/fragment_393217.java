long totalMins = 0;
final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
for (Verhuur verhuur : verhuurs) {
   Date date1 = format.parse(verhuur.begintijd);

   Date date2 = format.parse(verhuur.eindtijd);
   long difference = date2.getTime() - date1.getTime();
   total += ((difference/1000)/60);
}

System.out.println("total is " + total);
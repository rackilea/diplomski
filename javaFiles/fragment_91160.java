Date end;
try {
   end = formatter.parse(endStr);
} catch (ParseException e) {
   e.printStackTrace();
   end = new Date(); // default to now
}
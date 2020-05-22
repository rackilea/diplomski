Date end;
try {
   end = formatter.parse(endStr);
} catch (ParseException e) {
   e.printStackTrace();
   throw e;
}
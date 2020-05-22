DateFormat formatter =  null;
java.util.Date date = null;
formatter = new SimpleDateFormat("yyyy-MM-dd");
try{
  date = formatter.parse(stringDate);
  //if you want you can convert it to `java.sql.Date`
}catch(ParseException ex){//do whatever you would like to}

return date;
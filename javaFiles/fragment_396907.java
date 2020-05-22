String yourString = "5 12 2015 17:40:53";
Timestamp timestamp = null;

try{
    SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy hh:mm:ss");
    Date parsedDate = sdf.parse(yourString);
    timestamp = new java.sql.Timestamp(parsedDate.getTime());
}catch(Exception e){
 //this generic but you can control the type of exception
}
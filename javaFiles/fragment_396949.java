SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
try{
    Date d = df1.parse("2014-10-13T10:41:22.863+8:00");
    System.out.println("new date format " + df2.format(d));
}catch(Exception e){
   e.printStackTrace();
}
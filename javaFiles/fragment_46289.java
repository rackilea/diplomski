private static String printTimeStamp() {
    // TODO Auto-generated method stub

    java.util.Date date= new java.util.Date(); 
    String printTimeStamp =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date.getTime());
    return printTimeStamp;
}
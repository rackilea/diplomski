String line = (now.getYear()+1900) + " " + "Jul 27 12:50:15";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

if( timeFromLine.after( nowMinusGap ) &&
    timeFromLine.before( now ) ){
    System.out.println( "line: " + timeFromLine + " in range" );
}
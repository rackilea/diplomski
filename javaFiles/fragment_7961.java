Calendar gc = new GregorianCalendar();
long toBeg = gc.getTimeInMillis();
toBeg -= toBeg % (24*60*60*1000);
long toEnd = toBeg + 24*60*60*1000;

long now = gc.getTimeInMillis();
if( toBeg <= now && now < toEnd ){
    System.out.println( "today" );
}
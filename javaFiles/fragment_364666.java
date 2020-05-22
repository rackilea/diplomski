SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/d");
sdf.setLenient(false);
ParsePosition p = new ParsePosition( 0 );
String t1 = "2011/12/12aaa";    
System.out.println(sdf.parse(t1,p));

if(p.getIndex() < t1.length()) {
  throw new ParseException( t1, p.getIndex() );
}
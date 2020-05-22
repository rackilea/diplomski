Properties props = System.getProperties();
Enumeration e = props.propertyNames();
while( e.hasMoreElements() ){
    Object key = e.nextElement();
    Object val = props.getProperty( key.toString() );
    System.out.println( "key:"+ key +" val:"+ val );
}
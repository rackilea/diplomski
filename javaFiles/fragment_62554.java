boolean alleq = true;
for( String key1: map1.keySet() ){
    String value2 = map2.get( key1 );
    if( value2 != null && ! value2.equals( map1.get(key1) ) ){
        alleq = false;
        break;
    }
}
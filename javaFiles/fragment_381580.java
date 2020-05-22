Class2 c = new Class2();

List<Class2> bucket = map.get(c.fieldY);
if( null == bucket ){
    bucket = new ArrayList<>();
    map.put( c.fieldY, bucket );
}
bucket.add( c );
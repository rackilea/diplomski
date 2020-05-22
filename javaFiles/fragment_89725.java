List<? extends List<?>> theReallyNotSureList;

// these are fine
theReallyNotSureList = theAnyList;
theReallyNotSureList = theNotSureList;

// but we are prevented from doing this
theReallyNotSureList.add( new Vector<Float>() );
// as well as this
theReallyNotSureList.get(0).add( "a String" );
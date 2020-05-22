List<List<?>> theAnyList = new ArrayList<List<?>>();

// we can do this
theAnyList.add( new ArrayList<String>() );
theAnyList.add( new LinkedList<Integer>() );

List<?> typeInfoLost = theAnyList.get(0);
// but we are prevented from doing this
typeInfoLost.add( new Integer(1) );
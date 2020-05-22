List<? extends List<Float>> theNotSureList =
    new ArrayList<ArrayList<Float>>();

// we can still use its elements
// because we know they store Float
List<Float> aFloatList = theNotSureList.get(0);
aFloatList.add( new Float(1.0f) );

// but we are prevented from doing this
theNotSureList.add( new LinkedList<Float>() );
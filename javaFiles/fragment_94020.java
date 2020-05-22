public static void generateValues(List<Float> theList) {

  if (dummyValues.size() >= theList.size()) { 
    for (float value : theList) {
      dummyValues.set(theList.indexOf(value), value);
    }
  }
  else {
    for (float value : theList) {
      dummyValues.add(dummyValues.size(), value);
    }
  }
}
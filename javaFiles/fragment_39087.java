private void doAssertion(List testList, List generatedList){

  if (testList.get(0) instanceof X) {
    List<X> xList = (List<X>) testList;
    // call methods specific to X for each object
  } else if (testList.get(0) instanceof Y){
    List<Y> yList = (List<Y>) testList;
    // call methods specific to Y for each object
  }

}
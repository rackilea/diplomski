class Thing {
  Integer id;
  String name;
  String type;
  Integer[] children;

  public String printMe(Map<Integer, Thing> allThings) {
    String ret = "... format json stuff here";
    for(Integer childId in children) {
      Thing child = allThings.get(childId);
      ret += child.printMe(allThings);
    }
    ret += "Format json stuff here";
    return ret;
  } 
};
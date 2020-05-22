public <T> List<T> parseSomething(Node n){
  List<T> somethings = new ArrayList<T>();
  initialize();
  sameCodeInBothClasses();
  List<Node> nodes = getChildrenByName(n, "somename");
  for(Node n:nodes){
    method();
    actionA();
    somethings.add(new T(actionB());
  }
  return somethings;
}
public class AlmaContainer {
  List<AlmaObject> alma = new ArrayList<AlmaObject>();
}

public class AlmaObject {
  String name;
  String value;
  AlmaObject(name, value) {
     this.name=name
     this.value= value
  }
}
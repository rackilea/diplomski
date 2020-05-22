// our "struct"esque class for the linked data we're handling
class MyObject {
  String description;
  float value;
  Public MyObject(String description, float value) {
    this.description = description;
    this.value = value;
  }
}

// build our list of objects
ArrayList<MyObject> mylist = new ArrayList<MyObject>();
mylist.add(new MyObject("description1", 10));
mylist.add(new MyObject("description2", 12));
mylist.add(new MyObject("description3", 14));
...

// and then we iterate
String d; float v;
for(MyObject m: mylist) {
  d = m.description;
  v = m.value;
  ...
}
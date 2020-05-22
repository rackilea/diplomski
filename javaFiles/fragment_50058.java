Map<String, MyType> myMap = new HashMap<String, MyType>();
Iterator<Map.Entry<String, MyType>> iter = myMap.entrySet().iterator();
while(iter.hasNext()){
    MyType entry = iter.next().getValue();
    for (Field f : entry.getClass().getFields()) {
          if (f.isAccessible()) {
              //...
          }
    }
}
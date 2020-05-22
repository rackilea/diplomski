Map<MyOtherObj, String> anotherMap = new HashMap<>();

Map<? extends A, String> aMap = anotherMap;
aMap.put(new MyObj(), "");  // Can't do this; but if you could...

MyOtherObj obj = anotherMap.keySet().iterator().next();  // ClassCastException!
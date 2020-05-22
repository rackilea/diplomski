List<MyObject> myObjects = Lists.transform(myStrings,
   new Function<String, MyObject>() {
       private int i = 0;
       public MyObject apply(String stringValue) {
           return new MyObject(i++, stringValue);
       }
   });
Object myValue =  myMap.get("myKey");
   if (!(myValue instanceof Short)){          
      throw new YourRuntimeException("A Short is expected but get a " + myValue.getClass());
      // or ignore the value
   }

   if (Arrays.asList(MyEnum.values())
              .contains(MyEnum.fromValue(((short) myValue)) {
           ....
    }
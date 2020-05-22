Map<String,Integer> myMap = 
    myList.stream()
          .collect(Collectors.groupingBy(
            myClass::getA, 
            Collectors.summingInt(myClass::getB)
          ));
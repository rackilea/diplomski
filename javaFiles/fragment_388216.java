Map<String,myOutput> myMap = 
        myList.stream()
              .collect(Collectors.groupingBy(
                myClass::getA, 
                Collector.of(myOutput::new, myOutput::accept, myOutput::combine)
              ));
return list.stream()
           .map(myObject -> {
               if (myObject.getA() == null) {
                   myObject.setA(0.0);
               }
               return myObject;
           })
           .collect(Collectors.toList());
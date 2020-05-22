Optional<TestDto> optional = testList.stream().filter(typePredicate).findFirst();
       // ^ Generics!

if(optional.isPresent()){
    System.out.println("if-output = " + optional.get().getValue());
}

Double value = optional.isPresent() ? optional.get().getValue() : Double.valueOf(0);

System.out.println(value);
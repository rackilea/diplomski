final String joinSeparator = ", ";

    String firstResult = stringList
            .stream()
            .collect(Collectors.joining(joinSeparator));

    String secondResult = myClassList
            .stream()
            .map(MyClass::getMyString)
            .collect(Collectors.joining(joinSeparator));

    //Just compare them using equals:
    System.out.println(firstResult.equals(secondResult));
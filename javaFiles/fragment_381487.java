//your input
    String numbers = "-25+26+78-21";
    //split lookahead by + or - and store them in array of strings
    //you can do with it afterwards whatever you like, turn it into ints for example
    String[] tokens = numbers.split("(?=\\-)|\\+");
    System.out.println(Arrays.asList(tokens));
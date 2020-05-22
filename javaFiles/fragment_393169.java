String test = "||||||||";
    String[] testArray = test.split("\\|\\|\\|\\|", -1);
    for (String t : testArray) {
        System.out.println("Data " + t);
    }
    System.out.println("test " + test + " size :" + testArray.length);
    test = "a||||b||||c";
    System.out.println("---------");
    testArray = test.split("\\|\\|\\|\\|", -1);
    for (String t : testArray) {
        System.out.println("Data " + t);
    }
    System.out.println("test " + test + " size :" + testArray.length);
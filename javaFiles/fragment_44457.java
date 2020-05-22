String sentence="name    password    A";
    String[] result =sentence.split("\\s+");

    System.out.println("username " + result[0]);
    System.out.println("password " +result[1]);
    System.out.println("type " + result[2]);
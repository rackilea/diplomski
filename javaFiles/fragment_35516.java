String foo = "name:lala,id:1234,phone:123";
    // get all all key/value pairs into an array
    String[] array = foo.split(",");
    // check every key/value pair if it starts with "id"
    // this will get the id even if it is at another position in the string "foo"
    for (String i: array) {
        if (i.startsWith("id:")) {
            System.out.println(i.substring(3));
        }
    }
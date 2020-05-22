String[] array = "A B C -> D".split("->");
    //splits your string into two strings, and stores them in an array
    //array[0] = "A B C " -- all elements before ->
    //array[1] = " D" -- all elements after ->
    String[] input = array[0].trim().split(" "); 
    // trim is used to remove trailing/leading white spaces
     String[] output = array[1].trim().split(" ");
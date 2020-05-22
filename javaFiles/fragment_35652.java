// testing integers, comma-separated and floats
String test = "1 * 2i + 3.3i / 4.4 ^ 5,555i * 6,666 + 7,777.7i / 8,888.8";
System.out.println(
    test
    .replaceAll(
       //| group 1: whole expression
       //| | any 1+ digit
       //| |  | optional comma + digits
       //| |  |       | optional dot + digits
       //| |  |       |         | final "i"
        "(\\d+(,\\d+)?(\\.\\d+)?)i", 
        "complex(0, $1)"
    )
);
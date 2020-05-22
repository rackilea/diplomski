String spaces = "1 2  3   4    1 5     end";
System.out.println(
    //                 | space followed by space
    //                 |        | or
    //                 |        | | space preceded by space
    spaces.replaceAll("\\s(?=\\s)|(?<=\\s)\\s", "&nbsp;")
);
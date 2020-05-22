String str = "There is, a more optimal, way to obtain. subtrings which,"
           + "are separated by, and ended by. than this way.";

String[] substrings = str.split("\\s*[.,]\\s*");
for (String substr : substrings)
    System.out.println("\"" + substr + "\"");
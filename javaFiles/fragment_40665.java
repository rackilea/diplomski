jshell> String value = "5000\u0007";
value ==> "5000\007"

jshell> Integer.parseInt(value);
|  java.lang.NumberFormatException thrown: For input string: "5000"
|        at NumberFormatException.forInputString (NumberFormatException.java:65)
|        at Integer.parseInt (Integer.java:652)
|        at Integer.parseInt (Integer.java:770)
|        at (#15:1)
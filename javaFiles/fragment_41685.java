jshell> String n="3020857508"
n ==> "3020857508"

jshell> Integer a = Integer.parseInt(n.trim())
|  Exception java.lang.NumberFormatException: For input string: "3020857508"
|        at NumberFormatException.forInputString (NumberFormatException.java:65)
|        at Integer.parseInt (Integer.java:652)
|        at Integer.parseInt (Integer.java:770)
|        at (#2:1)

jshell> Integer.MAX_VALUE
$3 ==> 2147483647

jshell> Long a = Long.parseLong(n.trim());
a ==> 3020857508
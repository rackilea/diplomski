String expr = "(5 + 3) * 12 / 3";
.
. // Your inputs
.
String arr[] = expr.replaceAll("\\s+", "").split("(?<=[-+*/()])|(?=[-+*/()])");
for (String s : arr) 
{
    System.out.println("Element : " + s);
}
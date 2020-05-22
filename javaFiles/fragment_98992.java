String l = "150000";
String result = "";
for (int i = 0; i < l.length(); i++) {
    if (i != 0 && i % 3 == 0)
        result = result + "," + l.charAt(i);
    else
        result = result + l.charAt(i);
}
System.out.println(result);
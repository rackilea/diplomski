String str = "10 * 10 - 40 + 100/2 = 110";

//but first lets remove white spaces (it will makes regex easier)
String strWithoutSpaces=str.replaceAll("\\s+", "");

String[] tokens = strWithoutSpaces.split("(?<=[-+*/=])|(?=[-+*/=])");

for (String t:tokens)
    System.out.print(t+",");
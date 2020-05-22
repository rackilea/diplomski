String blankTileColor = (char) 27 + "[34;44m";
String tileColor = (char) 27 + "[36;44m";
String clear = (char) 27 + "[0m";

String tile1 = tileColor + "~";
String tile2 = blankTileColor + "~";
String tile3 = clear;

System.out.println(tile1.contains("~")); // true
System.out.println(tile2.contains("~")); // true
System.out.println(tile3.contains("~")); // false
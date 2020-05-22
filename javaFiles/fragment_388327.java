String newline = System.getProperty("line.separator");
String text = "before" + "/" + newline + newline + "--//" + "after";
System.out.println(text);

String delimiter = "/" + newline + newline + "--//";
String[] parts = text.split(delimiter);
System.out.println(parts[0]); // prints "before"
System.out.println(parts[1]); // prints "after"
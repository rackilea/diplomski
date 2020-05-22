String input = "1.9% 2581/candaemon: 0.4% user + 1.4% kernel";
String[] theParts = input.split("\\%");
for (int i=0; i < theParts.length; ++i) {
    theParts[i] = theParts[i].replaceAll("(.*)\\s([0-9\\.]*)", "$2");
}

System.out.println("total "  + theParts[0]);
System.out.println("user "   + theParts[1]);
System.out.println("kernel " + theParts[2]);
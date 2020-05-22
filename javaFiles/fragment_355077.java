Scanner a = new Scanner (System.in);
System.out.print("Enter string: ");
String s = a.nextLine();
String[] vals = {"a", "u", "o", "e", "i"};
for(String val : vals)
    s = s.replaceAll(val, "_");
System.out.println(s);
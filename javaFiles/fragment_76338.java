String str = "0000000100000002000000030000000400000005000000060000000700000008";
ArrayList<String> list = new ArrayList<>(); // To store results of cutting input String
while(str.length() != 0) { // Until you reach end of String...
    list.add(str.substring(0, 8)); // Add first eight characters of input String
    str = str.substring(8, str.length()); // Cut input String to leave only characters not added to list in previous line
}
String[] array = list.toArray(new String[list.size()]); // Create a String[] and add contents of ArrayList to it
System.out.println(Arrays.toString(array)); // Print result String[]
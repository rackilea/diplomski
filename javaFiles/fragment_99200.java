for (int i = 0; i < 3; i++) {
    c += Character.toString(x.charAt(i)); // Appending all the characters one by one
}

System.out.print(c); // Printing the String c after all the characters are appending

if (c.equals("USA")) { // checking if its equal to USA
    System.out.println("United State of America");
}
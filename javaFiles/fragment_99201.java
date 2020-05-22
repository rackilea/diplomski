c = ""; // re-initialize it to blank
for (int i = 3; i < 6; i++) {
    c += Character.toString(x.charAt(i));
}
System.out.print(c);
if (c.equals("IND")) {
    System.out.println("India");
}
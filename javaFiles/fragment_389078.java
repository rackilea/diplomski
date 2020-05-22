StringBuilder s1 = new StringBuilder("rohit");
StringBuilder s2 = new StringBuilder("jain");

s1.replace(0, s1.length(), s1.toString().toLowerCase());
s2.replace(0, s2.length(), s2.toString().toLowerCase());            

s1.setCharAt(0, Character.toTitleCase(s1.charAt(0)));
s2.setCharAt(0, Character.toTitleCase(s2.charAt(0)));

if (s1.toString().compareTo(s2.toString()) >= 0) {
    System.out.println(s2 + " " + s1);

} else {
    System.out.println(s1 + " " + s2);
}
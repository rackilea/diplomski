String[] x = input.split("-");
String initials = "";
for (String name : x) {
    initials += name.charAt(0);
}
System.out.println(initials);
String name = rs.getString(1);
String[] temp = name.split(" ");
char[] charAcro = new char[temp.length];
for (int i = 0; i < temp.length; ++i) {
    charAcro[i] = temp[i].charAt(0);
}
System.out.println(new String(charAcro));
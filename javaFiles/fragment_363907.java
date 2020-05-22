// hex representation of -889275714
int i = 0xcafebabe;
// just 1
int j = 1;
// represents both as hexadecimal String representations
String is = Integer.toHexString(i);
String ij = Integer.toHexString(j);
// pattern to check for letters
Pattern alpha = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
System.out.printf("\"%s\" contains characters, \"%s\" does not.%n", is, ij);
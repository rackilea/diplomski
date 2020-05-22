StringBuffer str2 = new StringBuffer(" I don't");
StringBuffer str3 = str2.append(" get it.");
String str = new String(str3.toString());
if (str == str.intern()) {
    System.out.println("It was not interned before"); // <<== This is printed
} else {
    System.out.println("It was interned before");
}
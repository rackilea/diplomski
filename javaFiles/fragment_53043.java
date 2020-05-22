String name = "B R ER";
String[] a = {"U","G"};
for(int i= 0 ; i < a.length ; i++) {
    String temp = name.replaceFirst("\\s", a[i]);
    name = temp;
}
System.out.println(name); // BURGER
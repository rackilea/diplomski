Teacher [] a = new Teacher[2];
for (int i = 0; i < a.length; i++) {
    System.out.println(i+">Name: ");
    String name = in.nextLine();
    a[i] = new Teacher(name, "123", "ECE", "sia", 234567);
}
System.out.println(a[a.length -1].toString());
for (int i = 0; i < a.length; i++) {
    System.out.println(a[i].getName());
}
int a;
Scanner s = new Scanner(System.in);
a = s.nextInt();
String[] x = new String[a];
String[] z = new String[a];
for (int i = 0; i < a; i++) {
    x[i] = s.next();
}
for (int i = 0; i < a; i++) {
    z[i]=x[i].replaceAll("S","A");
    z[i]=z[i].replaceAll("E","S");
    z[i]=z[i].replaceAll("A","E");
    System.out.println(z[i]);
}
int a=20;
int b=20;
final int c=a-b; // <-- make it final, then changing it is a compile error.
final int d=a+b;
System.out.println("c:"+c);
System.out.println("d:"+d);
int[] t = new int[0];
Object ot = t;
System.out.println(ot instanceof Object[]);
// --> prints 'false'
String[] s = new String[0];
Object os = s;
System.out.println(os instanceof Object[]);
// --> prints 'true'
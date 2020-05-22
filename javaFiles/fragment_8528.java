String t = "foobarbaz";
int l = t.length();
char[] a;
a = new char[l];
String rel = ",";
String ret = "";
for (int i = 0; i<l; i++){
    a[i] = t.charAt(i);
}
for (int v = 0; v<l; v++){
    ret += a[v];
    ret += rel;
}
System.out.println(ret);
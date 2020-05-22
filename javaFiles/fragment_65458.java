String l = "";
while (f > 0) {
    h = f % m; 
    f = f / m;
    l = h + l;
}
System.out.println(l);
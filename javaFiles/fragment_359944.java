String[] old = {"ABHISHEK","Name"};
String[] nw = {"Abhi","nick name"};
String s="My name is Abhishek";
//make sure old and nw have same size please
for(int i =0; i < old.length; i++) {
    s = s.replaceAll("(?i)"+old[i], nw[i]);
}
System.out.println(s);
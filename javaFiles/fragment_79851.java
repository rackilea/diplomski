List<SomeClass> list = new ArrayList<SomeClass>();
SomeClass s = null;
 while (rs.next()) {
s = new SomeClass();
s.name =  rs.getString(1);
.......
list.add(s);
    }
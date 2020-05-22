List<List<String>> tileRows= new ArrayList<List<String>>();
for(int i=8;i>0;i--) {
    list.add(i, new ArrayList<String>());
}

for(int i=8;i>0;i--) {
    //here the compiler knows tileRows.get(i) is a List<String>
    tileRows.get(i).add("foo");
    //uncomment the below line and you will get a compiler error
    //tileRows.get(i).add(new Object());
}
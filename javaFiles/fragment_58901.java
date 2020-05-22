List<Foo> fooList = fooService.getFooList();
final int fooListSize = fooList.size();
for(int i = 0; i < fooListSize ; i++){
    Foo foo = fooList.get(i);
    // ...
}
List<Whatever> completeList=new ArrayList():
   Future<Whatever> fut1=service1.search(...);
   Future<Whateva> fut2=service2.search(...);
   completeList.addAll(fut1.get());
   completeList.addAll(fut2.get();
    //here you got all the stuff in completeList
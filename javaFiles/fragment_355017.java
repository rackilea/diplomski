void asynchronousMain(){
  asyncDoSomethig(); //ignore the return result
}

void synchronousMain() throws Exception{
  Future<Void> f = asyncDoSomething();
  //wait synchronously for result
  f.get();
}
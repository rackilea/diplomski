public void doSomething() {
   Node node = new Node();
   foo(node);
    if(node == null) {
      System.out.println("Original node is null");
    } else {
      System.out.println("Original node is not null");
    }   
}
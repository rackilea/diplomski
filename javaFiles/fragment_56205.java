public UCMService(String service){
    super();  // First compiler adds a super() to chain to super class constructor
    dataMap = new DataMap();   // Compiler moves the initialization here (right after `super()`)
    System.out.println("2222");
    this.service = service;
}
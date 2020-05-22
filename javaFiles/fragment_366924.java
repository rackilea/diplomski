class Producer {   String producer = "once";

    /// returns the string and sets it to null
    // 
    String get() {
      String get = producer;
      producer = null;
      return get;
    }
}

class Consumer { Producer p = new Producer();
  Consumer() {
    out.println( "The value of producer is: " + p.get();
    out.println( "The value of producer is: " + p.get();
  }
}
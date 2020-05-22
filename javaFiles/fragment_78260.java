public class CircularFifoQueue<T> { 
  private CircularFifoBuffer buffer = new CircularFifoBuffer();

  public boolean add(T data) {
     return buffer.add(data);
  }    

  // implement all other methods that are needed
}
public class Test {

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();
    MyQueue.Work<Integer> work = new MyQueue.Work<Integer>() {
      @Override
      protected Integer callImpl() {
        return 5;
      }
    };

    queue.put(work);
    MyQueue.Work<Integer> sameWork = queue.tryPoll();
  }
}
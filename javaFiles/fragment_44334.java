class Example {
    protected Deque<Integer> queueEven = new ArrayDeque<Integer>();
    protected Deque<Integer> queueOdd = new ArrayDeque<Integer>();
    // you can synchronize on some mutable flag to finish, too.

    class Even extends Thread {
        public void run() {
            for (int i = 0; i < 10; i += 2) {
                synchronized (queueEven) {
                    queueEven.add( i);
                }
            }
        } 
    } 

    class Odd extends Thread {
        public void run() {
            for (int i = 1; i < 10; i += 2) {
                synchronized (queueOdd) {
                    queueOdd.add( i);
                }
            }
        } 
    } 

    class AddEvenOdd extends Thread {
        public void run() {
             while (true) {
                 int even;
                 synchronized (queueEven) {
                     even = queueEven.removeFirst();
                 }
                 int odd;
                 synchronized (queueOdd) {
                     odd = queueOdd.removeFirst();
                 }
                 int result = even + odd;
                 System.out.println("result="+result);
             }
        }
    }
}
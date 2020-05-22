public class Main {

  public static void main(String[] args) throws InterruptedException {
    int nThreads;

    if (args.length <= 0) {
      nThreads = 5;  // default number of threads
    } else {
      nThreads = Integer.parseInt(args[0]); // first passed parameter value 
    }

    int[] original = new int[1000000];
    for (int i = 0; i < original.length; i++) {
      original[i] = (int) (Math.random() * 9);
    }

    Mergesorts worker = new Mergesorts(original, nThreads);
    System.out.println("ressource: 1 of 5 thread(s) used");
    Thread w = new Thread(worker);
    w.start();
    w.join();

  }
}
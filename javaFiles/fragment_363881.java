class ReaderThread extends Thread {

  private final BlockingQueue<Integer> answers;

  ReaderThread(BlockingQueue<Integer> answers) { 
    this.answers = answers; 
  }

  @Override 
  public void run() {
    Scanner in = new Scanner(System.in);
    while (!Thread.interrupted()) 
      answers.add(in.nextInt());
  }

}
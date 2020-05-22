public class ExecutionTimer {
  private long start;
  private long end;

  public ExecutionTimer() {
    reset();
    start = System.currentTimeMillis();
  }

  public void end() {
    end = System.currentTimeMillis();
  }

  public long duration(){
    return (end-start);
  }

  public void reset() {
    start = 0;  
    end   = 0;
  }

  public static void main(String s[]) {
    // simple example
    ExecutionTimer t = new ExecutionTimer();
    for (int i = 0; i < 80; i++){
System.out.print(".");
}
    t.end();
    System.out.println("\n" + t.duration() + " ms");
  }
}
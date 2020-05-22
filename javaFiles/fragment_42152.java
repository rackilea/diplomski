import java.util.concurrent.*;

public class Test {
    private static class TestAction extends RecursiveAction {
        private int i;

        public TestAction(int i) {
            this.i = i;
        }

        protected void compute() {
            if (i == 0) {
                invokeAll(new TestAction(1), new TestAction(2), new TestAction(3),
                          new TestAction(4), new TestAction(5), new TestAction(6));
                return;   
            }             
            System.out.println(i + " start");
            try { Thread.sleep(2000); } catch (Exception e) { }
            System.out.println(i + " end"); 
        }   
    }       

    public static void main(String[] args) {
        new ForkJoinPool().invoke(new TestAction(0));
    }   
}
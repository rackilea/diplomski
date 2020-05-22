class MultiplyTable1 {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n*i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Prefer implementing Runnable over extending Thread.
// In reality I'd only have a single class and parameterize
// the value passed to the printTable method, but...
class Runnable1 implements Runnable {
    private final MultiplyTable1 table;

    Runnable1(MultiplyTable1 table) {
        this.table = table;
    }

    @Override public void run() {
        table.printTable(2);
    }
}

class Runnable2 implements Runnable {
    private final MultiplyTable1 table;

    Runnable2(MultiplyTable1 table) {
        this.table = table;
    }

    @Override public void run() {
        table.printTable(100);
    }
}

public class ThreadDemoDupe {
    public static void main(String[] args) {
        MultiplyTable1 table = new MultiplyTable1();
        Thread t1 = new Thread(new Runnable1(table));
        Thread t2 = new Thread(new Runnable2(table));
        t1.start();
        t2.start();
    }
}
public class Eieruhr {
    private int x;

    public Eieruhr(int x) {
        this.x = x;
    }

    public static void main(String[] args) throws InterruptedException {
        Eieruhr eu = new Eieruhr(10);
        eu.start();
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < x; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(new Date() + " tick - " + i);
        }
    }
}
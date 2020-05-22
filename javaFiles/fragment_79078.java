import java.util.ArrayList;

public class ProduceHamburgers {
    public static void main(String[] args) {
        HamburgerFactory hamburgerFactory = new HamburgerFactory();
        hamburgerFactory.delivery(5);
    }
}

class HamburgerFactory {

    private ArrayList<Hamburger> hamburgers = new ArrayList<>();
    private ArrayList<Hamburger> breads = new ArrayList<>();

    public void delivery(int amount) {
        for (int index = 0; index < amount; index++) {
            new Thread(() -> applyKetchup(), "applyKetchup-" + index).start();
        }
        for (int index = 0; index < amount; index++) {
            new Thread(() -> makeBread(), "makeBread-" + index).start();
        }
    }

    private synchronized void applyKetchup() {
        while (breads.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Hamburger current = breads.get(0);
        breads.remove(current);
        current.hadKetchup = true;
        System.out.print("applyKetchup！");
        hamburgers.add(current);
        this.notifyAll();
    }

    private synchronized void makeBread() {
         while (!breads.isEmpty()) {
             try {
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
        breads.add(new Hamburger());
        System.out.print("makeBread！");
        this.notifyAll();
    }

}

class Hamburger {
    public boolean hadKetchup = false;
}
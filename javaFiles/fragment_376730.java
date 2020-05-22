import java.util.Scanner;

public class MainClass {
public static void main(String[] args) {

    EntranceBarrier e1 = new EntranceBarrier(); // Entrance Barrier 1
    e1.setName("Bar1");
    EntranceBarrier e2 = new EntranceBarrier(); // Entrance Barrier 2
    e2.setName("Bar2");

    e1.start();
    e2.start();

    System.out.println("Open?");
    Scanner sc = new Scanner(System.in);
    int operation = sc.nextInt();

    while (operation != 0) {
        switch (operation) {
        case 1:
            e1.setOpen(true);
            e2.setOpen(true);
            System.out.println("Opt. 1 Working");
            break;
        case 2:
            e1.setOpen(false);
            e2.setOpen(false);
            System.out.println("Opt. 2 Working");
            break;
        default:
            System.out.println("NOPE");
            break;
        }

        System.out.println("Open?");
        operation = sc.nextInt();
    }
}
}
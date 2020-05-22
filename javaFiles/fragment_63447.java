import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RPG {

    private BufferedReader br;

    private RPG() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        RPG rpg = new RPG();
        rpg.run();
    }

    private void run() throws IOException {
        System.out.println("What do you want to do?\n"
                + "[1] Examine\n"
                + "[2] Speak\n"
                + "[3] Move");
        short choice = Short.parseShort(br.readLine());

        while (choice != 3) {
            switch (choice) {
                case 1:
                    System.out.println("What do you want to examine?\n"
                            + "[1] Bed\n"
                            + "[2] Closet\n"
                            + "[3] Vase\n"
                            + "[4] back");
                    short choice1 = Short.parseShort(br.readLine());
                    switch (choice1) {
                        case 1:
                            System.out.println("What a nice bed");
                            break;
                        case 2:
                            System.out.println("Better not touce the elder's things.");
                            break;
                        case 3:
                            System.out.println("This vase might break if i touched it ");
                            break;
                        case 4:
                            run();
                            return;
                    }
                    break;
                case 2:
                    System.out.println("Who do you want to speak to?\n"
                            + "[1] Maiden\n"
                            + "[2] Elder\n"
                            + "[3] Guard\n"
                            + "[4] Back");
                    short choice2 = Short.parseShort(br.readLine());
                    switch (choice2) {
                        case 1:
                            System.out.println("Hello there how are you feeling?\n"
                                    + "you falling must be very painful i hope you get well soon.");
                            break;
                        case 2:
                            System.out.println("Shoku is waiting for you in his tent go to him he will teach\n"
                                    + "you on how to fight. You will need it on your adventure.");
                            break;
                        case 3:
                            System.out.println("....*grunts* ");
                            break;
                        case 4:
                            run();
                            return;
                    }
                    break;
            }
        }
        System.out.println("Where to you want to go?\n"
                + "[1] Outside\n"
                + "[2] Stay inside");
        short choice3 = Short.parseShort(br.readLine());

        if (choice3 == 1) {
            System.out.println("Okey lets go ");
        }
    }
}
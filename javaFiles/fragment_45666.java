public class Zufallszahl {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Game g = new Game();
        Random rn = new Random();
        while(true) {
            g.start(rn.nextInt(100 -1) + 1, s);
            System.out.println("Noch ne Runde? Y/N");
            String response = s.next();
            if(response.equalsIgnoreCase("n")) return;
        }
    }

    public static class Game { 

        public void start(final int numberToGuess, final Scanner s) {
            int number = 0;
            int a = 0;
            while (number != numberToGuess ) {
                a++;
                System.out.print("Rate eine Zahl zwischen 0 und 100: ");
                number = s.nextInt();
                if (number == numberToGuess) {
                    System.out.println("richtig");
                    System.out.println("Du hast " + a + " Versuche gebraucht!");
                    return;
                }
                if (number < numberToGuess) {
                    System.out.println("zu klein");
                }
                if (number > numberToGuess) {
                    System.out.println("zu gross");
                }

            }
        }
    }
}
public class NewChanceOefententamen {

    public static boolean komtVoorIn(int zoekgetal, int[] lijst) { // de methode
                                                                // die
                                                                // checkt of
                                                                // het getal
                                                                // voorkomt
        for (int i = 0; i < lijst.length; i++) { // voor elk getal in het array
            if (zoekgetal == lijst[i]) { // als het overeenkomt met de waarde in
                                        // het array
                return true; // return true
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] zoekgetal = new int[3];
        int[] getal = new int[3];
        getal = new int[3];
        getal[0] = (int) (Math.random() * 8 + 1);
        getal[1] = (int) (Math.random() * 8 + 1);
        getal[2] = (int) (Math.random() * 8 + 1);
        zoekgetal = new int[1];

        System.out.println("geef 3 verschillende getallen tussen 1 en 8, gescheiden door spaties: ");
        zoekgetal[0] = input.nextInt();

        System.out.println(Arrays.toString(getal));

        if (komtVoorIn(zoekgetal[0], getal) == true) {
        } else {
        }
    }
}
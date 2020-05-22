public static void main(String[] args) {
        System.out.print("Hvor mange rekker vil du spille?: ");
        Scanner lesInn = new Scanner(System.in);
        int nummer = lesInn.nextInt();
        System.out.println("Lotto tallene er: ");
        System.out.println();

        for (int i = 0; i < nummer; i++) {
            int[] lottoNummer = trekk();
            for (int num : lottoNummer) {
                System.out.print(num + " ");
            }
            System.out.print("Tilleggstall:(" + lottoNummer[lottoNummer.length - 1] + ")");
            System.out.println();
        }
    }

    public static int[] trekk() {
        return new Random().ints(1, 35).distinct().limit(8).sorted().toArray();
    }
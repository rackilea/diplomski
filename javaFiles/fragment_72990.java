public static void main(String[] args) {
        System.out.print("Hvor mange rekker vil du spille?: ");
        Scanner lesInn = new Scanner(System.in);
        int nummer = lesInn.nextInt();
        System.out.println("Lotto tallene er: ");
        System.out.println();
        for (int i = 0; i < nummer; i++) {
            int[] lottoNummer = trekk();
            System.out.print(lottoNummer[1] + " ");
            System.out.print(lottoNummer[2] + " ");
            System.out.print(lottoNummer[3] + " ");
            System.out.print(lottoNummer[4] + " ");
            System.out.print(lottoNummer[5] + " ");
            System.out.print(lottoNummer[6] + " ");
            System.out.print(lottoNummer[7] + " ");
            System.out.print("Tilleggstall:(" + lottoNummer[7] + ")");
            System.out.println();
        }
    }

    public static int[] trekk() {
        return new Random().ints(1, 35).distinct().limit(8).sorted().toArray();
    }
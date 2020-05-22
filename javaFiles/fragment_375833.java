public static void main(String[] args) throws FileNotFoundException {

    File file = new File("E:\\american_tour.dat");

    Scanner scanner = new Scanner(file);

    //N in the example equals 16
    int N = scanner.nextInt();

    //skip the first line
    scanner.nextLine();

    int[][] adjMat = new int[N][N];

    for(int i = 0; i < N; i++){

        String[] lines = scanner.nextLine().split(",");

        for (int j=0; j<lines.length; j++) {
            adjMat[i][j] = Integer.parseInt(lines[j]);
        }
    }

    scanner.close();
}
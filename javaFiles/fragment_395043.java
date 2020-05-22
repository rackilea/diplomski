public static void main(String[] args) {
    try (FileInputStream textFile = new FileInputStream("EXAMPLE(2).txt")) {
        int i = 0, j = 0; // counters
        Scanner scan = new Scanner(textFile);
        N = scan.nextInt(); // read in the size
        String flush = scan.nextLine(); // gets rid of linefeed
        System.out.println(N);
        M = new int[N][N]; // instantiates array
        // this loop reads in matrix from input file
        String line;
        while (i < N && (line = scan.nextLine()) != null) {
            j = 0;
            String delim = " ";
            String tokens[] = line.split(delim);
            for (String a : tokens) {
                M[i][j] = Integer.parseInt(a);
                j++;
            }
            i++;
        }
        if (i > N)
            ;
        SV = scan.nextInt();

        try (PrintStream ps = new PrintStream("EXAMPLE(2).txt")) {
            printMatrix(M);
            System.out.println(SV);
            System.out.println();
            dijkstra(M, SV - 1, ps);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}
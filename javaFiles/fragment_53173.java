static void readFile() throws IOException {
    BufferedReader reader;
    reader = new BufferedReader(new FileReader("file.txt"));

    String firstDimension = reader.readLine();
    String[] split = firstDimension.split(" ");
    int firstX = Integer.parseInt(split[0]);
    int firstY = Integer.parseInt(split[0]);

    int[][] first = new int[firstX][firstY];

    for (int i = 0; i < firstX; i++) {
        String[] line = reader.readLine().split(" ");

        for (int j = 0; j < firstY; j++) {
            first[i][j] = Integer.parseInt(line[j]);
        }

    }

    // Read "@"
    reader.readLine();

    System.out.println(Arrays.deepToString(first));


}
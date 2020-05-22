public static void writeToFile(String filename) throws IOException {
    PrintWriter outputWriter = new PrintWriter("scores.txt");
    System.out.println("Please enter 10 scores.");
    System.out.println("You must hit enter after you enter each score.");
    Scanner sc = new Scanner(System.in);
    int score = 0;
    while (score < 10) {
        int val = sc.nextInt();
        if (val < 0)
            break;
        outputWriter.println(val);
        score++;
    }
    outputWriter.flush();
    outputWriter.close();
}
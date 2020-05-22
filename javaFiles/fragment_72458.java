public static void main(String[] args) throws FileNotFoundException {
    File file = new File("scores.csv");
    Scanner in = new Scanner(file);

    String run = "";
    int maleCount = 0;
    int femaleCount = 0;
    int maleScore = 0;
    int femaleScore = 0;

    while (in.hasNextLine()) {
        String current = in.nextLine();
        String[] split = current.split(",");
        if (split[0].toLowerCase().contains("f")) {
            femaleCount++;
            femaleScore += Integer.parseInt(split[1]);
            //                add score onto femaleScore
        } else {
            maleCount++;
            maleScore += Integer.parseInt(split[1]);
            //             add score onto maleScore
        }

    }

    double femaleAverage = femaleScore / femaleCount;
    System.out.println(femaleAverage);
    double maleAverage = maleScore / maleCount;
    System.out.println(maleAverage);

    in.close();
}
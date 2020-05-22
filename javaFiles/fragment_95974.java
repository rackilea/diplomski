public static void main(String[] args) throws FileNotFoundException {


    Scanner s = new Scanner(new File("results.txt"));// creates a scanner to
                                                    // scan from a file
    String line;
    String HomeTeam, AwayTeam;
    Int ValidNumb = 0, InvalidNumb = 0; //counters of valid and invalid lines
    Int AllScores = 0; //sum of all goals
    while (s.hasNext()) {
        line = s.nextLine(); // reads the next line from the file
        line = line.trim(); // trims the line
        String[] elements = line.split(":"); // splits the line
        if (elements.length == 4) {
            HomeTeam = elements[0].trim(); // trims home team
            AwayTeam = elements[1].trim(); // trims away team
            elements[2] = elements[2].trim();
            elements[3] = elements[3].trim();

            if (HomeTeam.length() != 0 && AwayTeam.length() != 0) { // check if position is present
                try {   // "try" is a special statement which allows us to deal with "exceptions"

                    int HomeScore = Integer.parseInt(elements[2]);  // attempt to convert the String into an Integer type value
                    int AwayScore = Integer.parseInt(elements[3]);
                    AllScores = AllScores + HomeScore + AwayScore; //sum up scores
                    System.out.println(HomeTeam + " ["+ HomeScore +"]" + " | " + AwayTeam + " ["+AwayScore+"]");
                    ValidNumb++; //line is valid
                }
                catch (NumberFormatException e) {
                    InvalidNumb++; //scores are not integers
                }

            }
            else {InvalidNumb++;} //HomeTeam or AwayTeam are empty

        }
        else {InvalidNumb++;} //not enough elements in line

    }

}
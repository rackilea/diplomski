public static boolean verifyFormat(String[] words) {
    // see endnote for isInteger()
    return words.length == 4 && /*isInteger(words[2]) && isInteger(words[3])*/;
}

public static void main(String[] args) throws FileNotFoundException {

    String hteam;
    String ateam;
    int hscore;
    int ascore;
    Scanner s = new Scanner(new BufferedReader(
            new FileReader("results2.txt"))).useDelimiter("\\s*:\\s*|\\s*\\n\\s*");

    while (s.hasNext()) {
        String line = s.nextLine();
        String[] words = line.split("\\s*:\\s*");

        if(verifyFormat(words)) {
            hteam = words[0];       // read the home team
            ateam = words[1];       // read the away team
            hscore = Integer.parseInt(words[2]);       //read the home team score
            ascore = Integer.parseInt(words[3]);       //read the away team score

            System.out.print(hteam);    // output the line of text to the console
            System.out.print(hscore);
            System.out.print(ateam);
            System.out.println(ascore);
        }
    }

    System.out.println("EOF");
}
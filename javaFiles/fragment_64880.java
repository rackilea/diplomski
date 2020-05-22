BufferedReader br = null;

String[] searches = new String[]{
            ",Animal Farm,Secker & Warburg,,",
            ",,Secker & Warburg,,",
            "George Orwell,,,,1",
            "Wilbur Smith,,,,",
            ",,,,1",
            "random,,,,1",
            "WILBUR SMITH,Birds of PREY,mcmillain,1992,1",
            ",,,,"
};

try {
    br = new BufferedReader(new FileReader("file.txt"));
    String line = null;

    // to store results of matches for easier output
    String[] matchResult = new String[searches.length];

    while ((line = br.readLine()) != null) {
        // go through all searches
        for (int i = 0; i < searches.length; i++) {

            /*
             *  replace all commas that don't have letters or numbers on both 
             *  sides with a new regex to match all characters
             */
            String searchPattern = searches[i].replaceAll("(?<![a-zA-z0-9])\\,|\\,(?![a-zA-z0-9\\,])", ".*,.*");

            // do the match on the line
            Matcher m = Pattern.compile("^" + searchPattern + "$", Pattern.CASE_INSENSITIVE).matcher(line);

            // store the result
            matchResult[i] = m.matches() == true ? "matches" : "no match";
        }

        System.out.println(String.format("%-50s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", line, 
                    matchResult[0], matchResult[1], matchResult[2], matchResult[3], matchResult[4], matchResult[5], matchResult[6], matchResult[7]));
    }
} catch (Exception e) {
        e.printStackTrace();
} finally {
    try {
        br.close();
    } catch (IOException e) {}
}
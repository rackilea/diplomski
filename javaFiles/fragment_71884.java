List<Team> readTeams() throws IOException {
    OUDialog.alert("Select input file for " + this.getPoolName());
    String fileName = OUFileChooser.getFilename();
    Path aFile = Paths.get(fileName);
    try (BufferedReader bufferedFileReader = Files.newBufferedReader(aFile)) {
        String currentLine = bufferedFileReader.readLine();
        if (currentLine != null && currentLine.equals(this.getPoolName())) {
            List<Team> teams = new ArrayList<>();

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] newStrings = currentLine.split(",");
                if (teams.length == 0) {
                    continue; // Allow empty lines
                }
                if (teams.length != 7) {
                    throw new IOException("Wrong line:" + currentLine);
                }
                Team newTeam = new Team(newStrings[0]);
                newTeam.setWon(Integer.valueOf(newStrings[1]));
                newTeam.setDrawn(Integer.valueOf(newStrings[2]));
                newTeam.setLost(Integer.valueOf(newStrings[3]));
                newTeam.setFourOrMoreTries(Integer.valueOf(newStrings[4]));
                newTeam.setSevenPointsOrLess(Integer.valueOf(newStrings[5]));
                newTeam.setTotalPoints(Integer.valueOf(newStrings[6]));
                teams.add(newTeam);
            }
            return teams;
        } else {
            throw new IOException("Wrong file selected");
        }
    } // Closes always.
}
public String getRandomAnswer() throws FileNotFoundException {
    Scanner fileScan = new Scanner(gameFile);
    int totalLines = 0;
    while (fileScan.hasNext()) {
        totalLines++;
        this.listStrings.add(fileScan.nextLine());
    }
    int randInt = (int) (Math.floor(Math.random() * totalLines));
    String randAns = listStrings.get(randInt);
    fileScan.close();

    return randAns;
}
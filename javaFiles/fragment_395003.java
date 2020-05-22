Lint<int[]> ret = new ArrayList<int[]>();

Scanner fIn = new Scanner(new File("pathToFile"));
while (fIn.hasNextLine()) {
    // read a line, and turn it into the characters
    String[] oneLine = fIn.nextLine().split("");
    int[] intLine = new int[oneLine.length()];
    // we turn the characters into ints
    for(int i =0; i < intLine.length; i++){
        if (oneLine[i].trim().equals(""))
            intLine[i] = 0;
        else
            intLine[i] = Integer.parseInt(oneLine[i].trim());
    }
    // and then add the int[] to our output
    ret.add(intLine):
}
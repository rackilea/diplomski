public Adventure(String file) throws UnknownRegionException {
    try {
        File inFile = new File(file);
        Scanner scan = new Scanner(inFile);
        int i = 0;
        while (scan.hasNext()) {
            String name = scan.nextLine();
            pokemon[i] = name;
            i++;
        }
    } catch (FileNotFoundException e) {
        throw new UnknownRegionException(e.getMessage());
    }
}
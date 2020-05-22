public void readText(int ages[], String names[]) throws FileNotFoundException{
    String filename = "";
    Scanner inputFile = new Scanner(System.in);
    File file;
    do {
        System.out.println("File to read from:");
        filename = inputFile.nextLine();
        file = new File(filename);
    } while (!file.exists());

    inputFile = new Scanner(file);

    while (inputFile.hasNextLine()) {
        String data = inputFile.nextLine();
        String[] parts = data.split("(?<=\\))(?=\\()");
        for (String part : parts) {
            String input = part.replaceAll("[()]", "");
            ages[count] = Integer.parseInt(input.split(", ")[0]);
            names[count] = input.split(", ")[1];
            count++;

        }
    }
}
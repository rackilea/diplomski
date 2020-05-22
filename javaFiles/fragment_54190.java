try(PrintWriter out = new PrintWriter(new BufferedWriter(
                                      new FileWriter(fileOutput)))) {
    while(sc2.hasNextLine()) {
        String line = sc2.nextLine();
        Scanner s2 = new Scanner(line);
        while(s2.hasNext()) {
            // use the words in line
        }
        // write the line
        out.println(line);
    }
}
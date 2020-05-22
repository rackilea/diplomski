while (fileIn.hasNextLine()) {
    String line = fileIn.nextLine();
    String[] bigParts = line.split(" ");
    String[] timeParts = bigParts[0].split(":");
    roster.add(new Time(
        Integer.parseInt(timeParts[0]), 
        Integer.parseInt(timeParts[1]), 
        bigParts[1]
    ));
}
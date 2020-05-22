Scanner scannerLines = new Scanner(file);
boolean alleFound = false;
boolean nrFound = false;
boolean minFound = false;
while (scannerLines.hasNextLine()) {
    String line = scannerLines.nextLine();
    if (!alleFound && line.contains(" alle ")) {
        line = line.replace(" alle ", " ");
        alleFound = true;
    } else if (alleFound && !nrFound) {
        line = line.replaceFirst("\\s\\d\\d\\s", " ");
        nrFound = true;
    } else if (alleFound && nrFound && !minFound) {
        line = line.replace("Min", " ");
        minFound = true;
    }
    writer.println(line);
}
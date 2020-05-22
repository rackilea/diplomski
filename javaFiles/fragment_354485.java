int i=0;
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (i == lineNumber) {
            if (line.length() >= charNumber) {
                line = line.substring(0,charNumber) + wantedChar +
                       line.substring(charNumber);
            }
        }
        writeFile(line);
        i++;
    }
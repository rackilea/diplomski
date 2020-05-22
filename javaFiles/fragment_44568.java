fileLines = Files.readAllLines(new File(this.fullFileName).toPath(), Charset.forName("UTF-8"));
CSVParser csvParser = new CSVParser(delimChar,quoteChar);
    for (String nextLine : fileLines) {
        try {
            csvLine = csvParser.parseLine(nextLine);
            ...do stuff...
        } catch (Exception ex) {
            ...report bad record and stuff..  
        }
    }
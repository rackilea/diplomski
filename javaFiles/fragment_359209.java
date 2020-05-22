private static final Pattern csvFieldPattern =
        Pattern.compile("(?<=[$,])(\"(\"\"|[^\"])*\"|[^,]*)");

/** This parse method requires the CSV file to have a header row */
public static List<RoadLinkRecord> parse(String csvFilePath) {
    // TODO accept Reader or maybe InputStream rather than file path
    File f = new File(csvFilePath);

    List<RoadLinkRecord> records = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(f));) {
        // get the header fields
        String line = br.readLine();
        List<String> headers = new ArrayList<>();
        {
            Matcher matcher = csvFieldPattern.matcher(line);
            while (matcher.find())
                headers.add(matcher.group());
        }

        // iterate through record fields
        int recordNum = 0;
        while ((line = br.readLine()) != null) {
            recordNum++;

            // allocate array to hold the fields
            String[] fields = new String[headers.size()];
            // use matcher to get each of the fields
            Matcher matcher = csvFieldPattern.matcher(line);
            for (int i = 0; i < headers.size(); i++) {
                if (!matcher.find()) {
                    throw new IllegalArgumentException(
                            "Couldn't find field '" + headers.get(i) + "' for record " + recordNum);
                }
                fields[i] = matcher.group();
            }
            if (matcher.find()) {
                throw new IllegalArgumentException("Found excess fields in record " + recordNum);
            }

            // add the record from this line
            records.add(new RoadLinkRecord(recordNum, fields));
        }
    } catch (IOException e) {
        // TODO trouble reading the file
    } catch (IllegalArgumentException e) {
        // TODO error while parsing the file
    }

    return records;
}
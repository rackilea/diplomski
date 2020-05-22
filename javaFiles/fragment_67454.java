String[] array = {}; // Array to hold the final readin in results
List<String> list = new ArrayList<>(); // List inteferface for processing file data.
try {
    // Using for/each and java.nio.file to process file contents.
    for (String line : Files.readAllLines(Paths.get("Data_File.txt"), StandardCharsets.UTF_8)) {
        line = line.trim(); // Trim the line of leading or trailing whitespaces.
        // Skip Blank Lines (if any) in file...
        if (line.equals("")) {
            continue;
        }
        // If a file line consists of two numerical values consisting
        // of one or more digits separated by one or more whitespaces... 
        if (line.matches("\\d+\\s+\\d+")) {
            // Split the line into Year and Population then
            // add them to the list.
            list.add(line.split("\\s+")[0]);  // Year
            list.add(line.split("\\s+")[1]);  // Population
        }
        // Otherwise the line must be a Name.
        else {
            // Add Name to the list.
            list.add(line);                   // Name
        }
    }
    // Convert List to String[] Array
    array = list.toArray(new String[0]);
}
catch (IOException ex) {
    System.err.println(ex);
}

// Display the results read in from file now contained within the array[] Array.
String arrayString = Arrays.toString(array);
// Remove Square Brackets ([]) for display.
System.out.println(arrayString.substring(1, arrayString.length() - 1));
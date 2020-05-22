String csvFile = "file2.txt";
String cvsSplitBy = "\\s*,\\s*"; // <-- adds support for white space(s)
                                 //     before or after the comma.
try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
    Map<String, Integer> hash = new HashMap<>();

    String line;
    while ((line = br.readLine()) != null) {
        String[] source = line.split(cvsSplitBy);
        String medium = source[0] + " " + source[1]; // <-- the key
        int val = Integer.parseInt(source[2]);       // <-- the value
        if (hash.containsKey(medium)) { // <-- is the key in Map?
            val += hash.get(medium);    // <-- yes, add the value.
        }
        hash.put(medium, val); // <--  store the value back in the Map.
    }
    // Iterate the entry set, display the "medium" and value.
    for (Map.Entry<String, Integer> entry : hash.entrySet()) {
        System.out.printf("Source [medium = %s , values = %d]%n",
                entry.getKey(), entry.getValue());
    }
} catch (IOException e) { // <-- FileNotFoundException is a sub-class.
    e.printStackTrace();
}
System.out.println("Done");
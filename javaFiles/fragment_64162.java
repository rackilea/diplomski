// Get the user's home directory
String home = System.getProperty("user.home");
File f = new File(home, "input.txt");
try {
    // Get all of the lines into a List
    List<String> lines = Files.readAllLines(f.toPath());
    // Get the line count to create an array.
    int[][] arr = new int[lines.size()][];
    // populate the array.
    for (int i = 0; i < lines.size(); i++) {
        // split each line on white space
        String[] parts = lines.get(i).split("\\s+");
        arr[i] = new int[parts.length];
        for (int j = 0; j < parts.length; j++) {
            // parse each integer.
            arr[i][j] = Integer.parseInt(parts[j]);
        }
    }
    // Display the multidimensional array.
    System.out.println(Arrays.deepToString(arr));
} catch (IOException e) {
    // Display any error.
    e.printStackTrace();
}
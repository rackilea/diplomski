public static void main(String[] args) throws Exception {
    String fileName = "maze.txt";
    String line = null;
    ArrayList<ArrayList<String>> lines = new ArrayList<>();

    // Setup FileReader, BufferedReader, and LineReader
    FileReader fileReader = new FileReader(fileName);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    // Get all the lines inside the maze file
    while ((line = bufferedReader.readLine()) != null) {
        ArrayList<String> lineList = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            // Adds a single character
            lineList.add(line.substring(i, i+1));
        }

        lines.add(lineList);
    }

    printMase(lines);
}

public static void printMase(ArrayList<ArrayList<String>> lines)
{
    for (ArrayList<String> row: lines)
    {
        for (String elem: row)
        {
            // Using print so each character is on the same line
            System.out.print(elem);
        }
        // Now use println to end the line
        System.out.println();
    }
}
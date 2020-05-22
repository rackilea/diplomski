public static void main(String[] args) {
    // provide the path to the file
    Path pathToFile = Paths.get("Y:\\our\\path\\to\\numbers.txt");
    // provide a list of lists of numbers
    List<List<Integer>> numbersInLines = new ArrayList<>();
    // or provide a single list of integers
    List<Integer> allNumbers = new ArrayList<>();

    // try reading the file, you may want to check if it exists and is valid before
    try {
        Files.lines(pathToFile).forEach(line -> {
            // provide a list for the numbers of each line
            List<Integer> realNumbers = new ArrayList<>();
            // split the line by an arbitrary amount of whitespaces
            String[] lineElements = line.trim().split("\\s+");
            // convert them to integers and store them in the list of integers
            for (String lineElement : lineElements) {
                // check if there is an empty String
                if (!"".equals(lineElement)) {
                    // add it to the list of the current line
                    realNumbers.add(Integer.valueOf(lineElement));
                    // and / or add it to the list of all numbers
                    allNumbers.add(Integer.valueOf(lineElement));
                }
            }
            // store the list of numbers of the current line in the list of lists
            numbersInLines.add(realNumbers);
        });
    } catch (IOException e) {
        e.printStackTrace();
    }

    // print each line list
    numbersInLines.forEach(lineNumbers -> {
        lineNumbers.forEach(System.out::print);
        System.out.println();
    });

    // and / or print all the numbers in a single line, separated by a whitespace
    allNumbers.forEach(number -> System.out.print(number + " "));
}
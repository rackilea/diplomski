public static void main(String... args) {
    IterableResult<String[], ParsingContext> rows = readCSV("c:/path/to/input.csv");

    try {
        for (String[] row : rows) {
            //process the rows however you want
        }
    } finally {
        //the parser closes itself but in case any errors processing the rows (outside of the control of the iterator), close the parser.
        rows.getContext().stop();
    }
}
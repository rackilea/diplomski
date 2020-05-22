public static void main(String[] args) throws Exception {
    File file = new File("src/maze.txt");
    List<Integer[]> columns = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        // Read the maze from the input file
        String line;
        while((line = reader.readLine()) != null){
            String[] tokens = line.split(",");
            Integer[] array = Arrays.stream(tokens)
                    .map(t -> Integer.parseInt(t))
                    .toArray(Integer[]::new);
            columns.add(array);
        }
    }
}
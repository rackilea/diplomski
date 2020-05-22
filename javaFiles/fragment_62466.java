public void genID() {
    ArrayList<Integer> casillero = new ArrayList<Integer>();
    for (int i = 100000; i < 1000000; i++) {
        casillero.add(new Integer(i));
    } Collections.shuffle(casillero);
    for (int i = 0; i < 1; i++) {
        System.out.println("El nuevo ID de casillero es: I" + casillero.get(i));
    }

    try {
        getUsedIDS().forEach(i -> {
            /*
             * Iterate through the existing IDs
             * and make sure that casillero does
             * not contain any of them.
             */
            if(casillero.contains(i)) casillero.remove(i);
        });
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public List<Integer> getUsedIDS() throws IOException {
    //The file which you saved the IDs to.
    File file = new File("IDs.txt");
    //Return all the values in the file.
    return Files.readAllLines(file.toPath()).stream().mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
}
public void saveIDs(List<Integer> IDs) throws FileNotFoundException {
    /*
     * Create a PrintStream that writes into a 
     * FileOutputStream which in turn writes to your file.
     * Because 'true' was passed to the constructor, this
     * stream will append to the file.
     */
    PrintStream s = new PrintStream(new FileOutputStream(new File("IDs.txt"), true));
    //Print every element in the IDs list.
    IDs.forEach(s::println);
    /*
     * Read more about flush here:
     * https://stackoverflow.com/a/2340125/5645656
     */
    s.flush();
    /*
     * Close the stream to prevent a resource leak.
     */
    s.close();
}
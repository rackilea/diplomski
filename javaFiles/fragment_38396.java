public static void main(String[] args) throws FileNotFoundException {
    if (args.length != 1) {
        System.err.println("Filename argument missing.")
        System.err.println("Usage: <command> <filename>");
        System.exit(1);
    }

    Memory myMemory = new Memory();
    File file = new File(args[0]);
    myMemory.fileParser(file);
}
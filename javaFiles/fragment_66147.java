File hi = new File("hi.txt");
try {
    if (!hi.exists()) {
        System.out.printf("\nCreating 'hi.txt'.");
        hi.createNewFile();
        String hello = "List:";
        FileWriter writer = new FileWriter(hi, true);
        writer.append(hello);
        writer.close();
    } else {
        System.out.printf("\nWriting to 'hi.txt'");
    }
    FileWriter writeHere = new FileWriter(hi, true);
    String uling = "hi";
    writeHere.append(uling);
    writeHere.close();
}
//error catching
catch (IOException e) {
    System.out.printf("\nError. Check the file 'hi.txt'.");
}
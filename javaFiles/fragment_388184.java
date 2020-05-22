try {
    Scanner in = new Scanner(new File("text.txt"));
    Formatter out = new Formatter("text1.txt");
    in.useDelimiter(",|\n|\r\n|\\s+");
    int num = in.nextInt();
    for(int i = 0; i < num && in.hasNext(); i++)
        out.format("string # %d is: [%s]\n", i, in.next() );
    out.close();
}
catch (Exception e) {
    System.err.print("Exception: " + e);
}
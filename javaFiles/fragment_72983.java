try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)));
    out.println("the text");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
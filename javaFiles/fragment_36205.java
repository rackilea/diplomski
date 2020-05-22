try(FileWriter fw = new FileWriter("outfilename", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println("the text"); // appends text
    //more code
    out.println("more text"); // appends text
    //more code, append more text etc.

} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
FileWriter fw = null;
BufferedWriter bw = null;
PrintWriter out = null;
try {
    fw = new FileWriter("myfile.txt", true);
    bw = new BufferedWriter(fw);
    out = new PrintWriter(bw);
    out.println("the text");
    out.close();
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
finally {
    try {
        if(out != null)
            out.close();
    } catch (IOException e) {
        //exception handling left as an exercise for the reader
    }
    try {
        if(bw != null)
            bw.close();
    } catch (IOException e) {
        //exception handling left as an exercise for the reader
    }
    try {
        if(fw != null)
            fw.close();
    } catch (IOException e) {
        //exception handling left as an exercise for the reader
    }
}
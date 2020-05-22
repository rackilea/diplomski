public class MyBufferedWriter extends BufferedWriter {
    public void write(String str) {
        if (str==null)
            str="";
        super.write(str);
    }
}
public class JobResponseWriter extends FileWriter{
    private final File myFile;
    public JobResponseWriter(Job job) throws IOException {
        this(File.createTempFile("JobResponse" + job.getId() ,"tmp"));
    }
    public JobResponseWriter(File f) throws IOException {
        super(f);
        myFile = f;
    }
    /* your code here */
}
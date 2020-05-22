public class RunWithParameters implements Runnable {

    private String sourceFile;
    private String targetFile;

    public RunWithParameters(String sourceFile, String targetFile) {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
    }

    public void run() {
        // your business logic with sourceFile and targetFile
    }
}
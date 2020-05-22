public class Report {
    private boolean bICanWrite = false;

    public Report(boolean WriteAccess) {
        bICanWrite = WriteAccess;
    }

    public void open() {
        if(bICanWrite == true) {
            //Open in write mode
            System.out.println("Report open in Write mode");
        }
        else {
            //Open in readonly mode
            System.out.println("Report open in Read only mode");
        }
    }

    public synchronized void close() {
        if(bICanWrite == true) {
            ReportUtil.resetLock();
        }
    }
}
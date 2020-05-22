public class Client {

    public static void main(String[] args) {
        Report report1 = ReportUtil.getReport();
        report1.open(); //First time open in writable mode

        Report report2 = ReportUtil.getReport();
        report2.open(); //Opens in readonly mode

        Report report3 = ReportUtil.getReport();
        report3.open(); //Opens in readonly mode

        report1.close(); //close the write mode

        Report report4 = ReportUtil.getReport();
        report4.open(); //Opens in writable mode since the first writeable report was closed
    }

}
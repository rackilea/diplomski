import java.util.LinkedList;

public class ReportUtil {

    private static boolean bIsWriteLockAvaialable = true;

    public static synchronized Report getReport() {
        Report reportObj = new Report(bIsWriteLockAvaialable);
        if(true == bIsWriteLockAvaialable) {
            bIsWriteLockAvaialable = false;
        }
        return reportObj;
    }   

    public static void resetLock() {
        bIsWriteLockAvaialable = true;
    }
}
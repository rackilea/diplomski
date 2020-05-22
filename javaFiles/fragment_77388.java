public class DiagnosticUtil {
    private final static int threshold = 1000;
    private static List<String> messages = new ArrayList<>();
    private static final File log = new File("path to your file");

    public static void addDiagnosticLine(String message) {
        if (messages.size() > threshold) {
            try (BufferedWriter file = new BufferedWriter(new FileWriter(log))) {
                for (String msg : messages) {
                    file.write(msg);
                }
                file.flush();
            } catch (IOException e) {
                Timber.d("Error saving additional data " + e);
            }
            messages = new ArrayList<>();
        } else {
            messages.add(TimeUtils.getCurrentDate() + message + "\n");
        }
    }
}
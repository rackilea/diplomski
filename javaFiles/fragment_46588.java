public class MainClass {

    private static boolean isTaskCompleted;

    public void genericMethod() {
        if(isTaskCompleted()) {
            // your operation here
        }
    }

    private boolean isTaskCompleted() {
        return isTaskCompleted;
    }

    public static void taskIsCompleted(boolean bool) {
        isTaskCompleted = bool;
    }

}
public class SingletonExitCode {

    public ExitCode exitCode = ExitCode.ABNORMAL_END_OF_EXECUTION_WARNING; // Default code 3
    private static SingletonExitCode instance = new SingletonExitCode();

    private SingletonExitCode() {}

    public static SingletonExitCode getInstance() {
        return instance;
    }

    public void setExitCode(ExitCode exitCode) {
        this.exitCode = exitCode;
    }
}
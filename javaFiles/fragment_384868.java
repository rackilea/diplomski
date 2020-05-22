import cucumber.api.cli.Main;

public class UseCukeFromMain {
    public static void main(String[] args) throws Throwable {
        Main.main(new String[]{
            "--glue",
            "com/cuke", // the package which contains the glue classes
            "/tmp/cuke-test/features/cukefeature.feature"}
        );
    }
}
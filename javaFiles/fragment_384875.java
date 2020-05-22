import cucumber.api.cli.Main;

public class UseCukeFromMain {
    public static void main(String[] args) throws Throwable {
        Main.main(new String[]{
            "--glue",
            "com/cuke",
            "--glue",
            "com/cuke1",
            "features/cukefeature.feature"}
        );
    }
}
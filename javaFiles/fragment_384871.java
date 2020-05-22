import cucumber.api.cli.Main;

public class UseCukeFromMain {
    public static void main(String[] args) throws Throwable {
        Main.main(new String[]{
            "--glue",
            "",  // to used Step definitions in default package
            "features/cukefeature.feature"}
        );
    }
}
public class Main {

    public static void main(String[] args) {
        if (args != null && args.length > 0 && args[0].equals("cli")) {
            String pathToProperties = args[1];
            Cli cli = new Cli(pathToProperties);
            cli.loadPropertiesAndGenerateApk();
        } else {
            Application.launch(GUIApp.class, args);
        }
    }
}
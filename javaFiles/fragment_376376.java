import javafx.application.Application;

public class Launcher {

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("test")) {
            Application.launch(TestApp.class, args) ;
        } else {
            Application.launch(ProductionApp.class, args);
        }
    }
}
import javafx.concurrent.Task;

public class Datasource {

    public static Task<Void> loadFromArxml() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // Do your processing here

                updateProgress(0, 100);

                // Run for 5 seconds
                int i = 0;
                while (i < 100) {
                    Thread.sleep(50);
                    i++;

                    updateProgress(i, 100);
                }

                return null;
            }
        };
    }
}
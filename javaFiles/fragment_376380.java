public class HeadlessApp {

    public static void main(String[] args) {
        DataModel data = new DataModel("Testing");
        data.textProperty().addListener((obs, oldValue, newValue) -> 
            System.out.printf("Text changed from %s to %s %n", oldValue, newValue));
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException exc) {
                throw new Error("Unexpected Interruption", exc);
            }
            data.setText("Hello World!");
        });
        thread.start();
    }

}
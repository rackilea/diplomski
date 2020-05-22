@Override
public void handle(long now) {
        if (now - time > 1_000_000_000) {
            count++;
            if (count == 5) {
                Alert alert = new Alert(AlertType.INFORMATION, "Hi there");
                Platform.runLater(alert::showAndWait);
            }
            time = now;
        }
}
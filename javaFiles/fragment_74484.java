@Override
public void update(Observable o, Object arg) {
    System.out.println(arg);
    Platform.runLater(() -> {
        textArea.setText(textArea.getText() + "\n" + arg);
        textArea.positionCaret(textArea.getText().length());
    });
}
textArea.setOnKeyReleased(event -> {
    if(event.getCode() == KeyCode.ENTER) {
        String[] lines = textArea.getText().split("\n");
        executeTask(textArea, lines[lines.length - 1]);
    }
});
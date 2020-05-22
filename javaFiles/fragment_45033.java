final TextArea ta = new TextArea() ;

// ...

Platform.runLater(new Runnable() {
    @Override
    public void run() {
        ta.appendText(scanner.next());
    }
});
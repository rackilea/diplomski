class Button() {

    private Runnable runnable;

    public Button (... Runnable runnable ){
       this.runnable  = runnable;
    }

    // Extra code
    void onClick() {
        runnable.start();
    }
}
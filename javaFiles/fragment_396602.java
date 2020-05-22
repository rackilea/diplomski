class PlayEngine implements Runnable {
    private final File file;

    PlayEngine(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        //do your stuff here
        play(file);
    }
}
Thread add = new Thread() {
    @Override public void run() {
        Editor tool = new Editor();
        tool.addModule("modules.csv");
    }
}
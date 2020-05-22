public void run() {
    try {
        this.socket = new Socket(this.IP, this.port);
        this.openAL = new OpenAL();
    } catch (Exception ex) {
        Log.severe(ex.toString());
    }
    this.mainCycleMethod();
}
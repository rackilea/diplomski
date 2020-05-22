public GetData extends Thread {
    public GetData(MyMainClass instance) {
        this.instance = instance;
    }

    private MyMainClass instance;

    @Override
    public void run() {
        String text;

        /* Download text from HTTP and save it to "text".
         * Every 1 seconds to about 10 minutes using stream API.
         * text= "abc...";
         * If there are no errors, run method never exit.
         */
        instance.useText(text);
    }
}
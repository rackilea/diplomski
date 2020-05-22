protected Void doInBackground() throws Exception {

    for (int i = 1; i <= 10; i++)
        try {
            frame.setOpacity(i/10.0);
            Thread.sleep(30);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    return null;
}
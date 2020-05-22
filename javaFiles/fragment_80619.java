new Thread(new Runnable() {
    @Override
    public void run() {
        URL website = new URL("MY_URL");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("grafik");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}).start();
private void initializeDns(String url) {
    try {
        InetAddress address = InetAddress.getByName(url);
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }
}
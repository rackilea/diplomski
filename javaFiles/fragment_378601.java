public InetAddress getServerAddress() {
    for (String address : new String[] {serverSettings.getString("serverIp"), DEFAULT_IP}) {
        try {
            return InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            Log.e("ERROR:", "Cannot resolve " + address);
        }
    }
    Log.e("ERROR:", "Total fail, exiting");
    finish();
    return null;    // not reached
}
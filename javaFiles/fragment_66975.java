public boolean disconnect() { 

    ProcessBuilder builder = new ProcessBuilder("pkill", "wvdial");
    try {
        builder.start();
        return true;
    } catch (IOException e) {
        return false;
    }
}
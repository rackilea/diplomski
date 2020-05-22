public static final int SCARD_CTL_CODE(int command) {
    boolean isWindows = System.getProperty("os.name").startsWith("Windows");
    if (isWindows) {
        return 0x00310000 | (command << 2);
    } else {
        return 0x42000000 | command;
    }
}
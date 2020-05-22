public static String[] getMacAddressParts(String macAddress) {
    String[] parts = macAddress.split(":");
    if (parts.length == 0) {
        parts = new String[6];
        for (int i = 0; i < 6; i++) {
            parts[i] = macAddress.substring(i * 2, i * 2 + 1);
        }
    }
    return parts;
}
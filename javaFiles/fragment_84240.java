public static String setUnit(double total) {

    String tutto = null;
    String suffisso = null;

    //if param passed to setnit() is < 1024 and > 0
    //we don't have to to any calculations on total
    //simply return it as it is with B (byte) as unit
    if (total >= 0 && total < 1024) {
        suffisso = " B";
        tutto = String.format("%.1f", total) + suffisso;
    }

    if (total >= 1024) {
        suffisso = " KB";
        total /= 1024;
        tutto = String.format("%.1f", total) + suffisso;
    }

    if (total >= 1024) {
        suffisso = " MB";
        total /= 1024;
        tutto = String.format("%.1f", total) + suffisso;
    }

    if (total >= 1024) {
        suffisso = " GB";
        total /= 1024;
        tutto = String.format("%.1f", total) + suffisso;
    }

    return tutto;
}
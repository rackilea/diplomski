public static void longLog(String str) {
    if (str.length() > 4000) {
        Log.d("", str.substring(0, 4000));
        longLog(str.substring(4000));
    } else
        Log.d("", str);
}
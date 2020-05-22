private void method(String txt) {
    Pattern pattern = Pattern.compile(("md5_id=[a-zA-Z_0-9]{5,}"));

    Matcher m = pattern.matcher(txt);
    while (m.find()) {
        Log.d("log", m.group());

    }
}
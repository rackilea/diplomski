int value = 0;
if (! TextUtils.isEmpty(arg0)) {
    String text = arg0.toString();
    if ("-".equals(text)) {
        // Nothing to do
    } else {
        value = Integer.parseInt(text);
    }
    seekBar.setProgress(value);
}
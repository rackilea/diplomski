String[] split = barcodeFields.split("\\^");
for (int i = 0; i < split.length; ++i) {
    if (split[i].length() == 0) {
        split[i] = "empty";
    }
}
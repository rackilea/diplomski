public static String audienceFormat(int number) {
    String value = String.valueOf(number);

    if (value.length() > 6) {
            value = value.replaceFirst("(\\d{1,3})(\\d{3})(\\d{3})", "$1\u00B4$2,$3");
        } else if (value.length() >=5 && value.length() <= 6) {
            value = value.replaceFirst("(\\d{2,3})(\\d{3})", "$1,$2");
        }  else {
            value = value.replaceFirst("(\\d{1})(\\d+)", "$1,$2");
        }

    return value;
}
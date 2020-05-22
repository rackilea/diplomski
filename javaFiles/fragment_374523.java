String text = "1 2 \"333 4\" 55 6    \"77\" 8 999";
    // 1 2 "333 4" 55 6    "77" 8 999

    String regex = "\"([^\"]*)\"|(\\S+)";

    Matcher m = Pattern.compile(regex).matcher(text);
    while (m.find()) {
        if (m.group(1) != null) {
            System.out.println("Quoted [" + m.group(1) + "]");
        } else {
            System.out.println("Plain [" + m.group(2) + "]");
        }
    }
int combinations = 0;
    String pass = "!!AAabas1";
    if (Pattern.compile("[0-9]").matcher(pass).find()) {
        combinations = combinations + 10;
    }

    if (Pattern.compile("[a-z]").matcher(pass).find()) {
        combinations = combinations + 26;
    }

    if (Pattern.compile("[A-Z]").matcher(pass).find()) {
        combinations = combinations + 26;
    }
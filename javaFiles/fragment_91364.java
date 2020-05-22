Pattern pattern = Pattern.compile("/\\^(.*?)\\|");

    String input = "/^/^this is a big|/*this is a bold text|/-this is strike through|";
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        System.out.println("Found: " + matcher.group(1));
    }
    System.out.println("That’s all, folks");
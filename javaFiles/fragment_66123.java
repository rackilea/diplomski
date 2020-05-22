String[] strings = {
            "213-333-4444",
            "233.444.5556",
            "(636) 434-5555"
    };
    String regex = "(\\D*\\d{3}\\D*)[\\d]{3}(.?)[\\d]{4}";
    String replacement = "$1222$22222";
    for (String string : strings) {
        System.out.println(string.replaceAll(regex, replacement));
    }
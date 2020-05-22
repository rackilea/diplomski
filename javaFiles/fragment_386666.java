List<String> names = Arrays.asList(
        "Success 100 - Operation worked John",
        "Success 100 - It also worked for Harry",
        "ERROR 4514 for Sally. It's always Sally.");

Predicate<String> IS_ERROR = name -> name.startsWith("ERROR");
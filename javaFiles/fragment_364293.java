String pattern = "mgth".chars()
            .mapToObj(ch -> "(?=.*" + (char) ch + ")")
            .collect(Collectors.joining());

    // ".*(?=.*m)(?=.*g)(?=.*t)(?=.*h).*"
    boolean matches = Pattern.compile(".*"+pattern+".*")
            .matcher("algorithm")
            .matches();

    System.out.println(matches);
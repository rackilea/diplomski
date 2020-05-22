List<String> output = new ArrayList<>();
    System.out.println(matcher.groupCount());
    while (matcher.find()) {
        System.out.println(matcher.group(1).trim());
        output.add(matcher.group(1).trim().replace(",", ""));

    }
    output.forEach(System.out::println);
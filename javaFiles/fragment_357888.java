List<String> strings = Arrays.asList("#ignored", "this", "is", "#ignored", "working", "fine", "!Someother", "*star");
    Function<String, String> classifier = s -> {
        if (s.matches("^[!@#$%^&*]{1}.*")) {
            return Character.toString(s.charAt(0));
        } else {
            return "others";
        }
    };
    Map<String, List<String>> maps = strings.stream().collect(Collectors.groupingBy(classifier));
    System.out.println(maps);
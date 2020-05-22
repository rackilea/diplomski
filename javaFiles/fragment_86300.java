String str = "This line: - has word separated by, : and -";
    List<String> words = new ArrayList<String>();

    Matcher matcher = Pattern.compile("\\w+").matcher(str);

    while (matcher.find()) {
        words.add(matcher.group());
    }

    System.out.println(words);
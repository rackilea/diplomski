String s1 = "ab";
    String s2 = "aaaகுb";

    Pattern pattern = Pattern.compile("\\p{L}\\p{M}*");

    Matcher matcher = pattern.matcher(s2);
    Set<String> missingCharacters=new TreeSet<>();
    while (matcher.find()) {
        missingCharacters.add(matcher.group());
    }

    matcher = pattern.matcher(s1);
    while (matcher.find()) {
        missingCharacters.remove(matcher.group());
    }

    System.out.println(missingCharacters.size());
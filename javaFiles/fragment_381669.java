final String regex = "\\$!.*?!\\$";
    final String string = "Which sentence explains why the slope of $!\\overline{AB}!$ is equal to the slope of $!\\overline{BC}!$?";
    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(string);
    final String result = matcher.replaceAll("");
    System.out.println(result);
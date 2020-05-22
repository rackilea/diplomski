ByteArrayOutputStream baos = new ByteArrayOutputStream();

    IOUtils.copyLarge(getClass().getClassLoader().getResourceAsStream("input.txt"), baos);
    String org = baos.toString();

    final Pattern compile = Pattern.compile("(?s)(create table a_.*?\n\\)\n)");
    final Matcher matcher = compile.matcher(org);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
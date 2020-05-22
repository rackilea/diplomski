String[] regex = { "int", ";", "++", "=" };
    StringBuilder pattern = new StringBuilder();
    for (String r : regex) {
        pattern.append('|').append(Pattern.quote(r));
    }

    String input = "int a=10; a++;";
    Matcher m = Pattern.compile(pattern.substring(1)).matcher(input);
    // e.g. m = Pattern.compile("int|;|\\+\\+|=").matcher(input);
    List<String> result = new ArrayList<String>();
    for (int i=0 ; m.find() ; i = m.end()) {
        if (i != m.start()) {
            result.add(input.substring(i, m.start()));
        }
        result.add(m.group(0));
    }
    String[] array = result.toArray(new String[result.size()]);
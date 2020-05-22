IntStream.iterate(0, i -> i+1).limit(50000).parallel().forEach((i) -> {

    Matcher mat = p.matcher(s);
    StringBuffer sb = new StringBuffer();

    while (mat.find()) {
        String repString = m.get(mat.group(1));
        if (repString != null) {
            mat.appendReplacement(sb, repString);
        }
    }
    mat.appendTail(sb);
});
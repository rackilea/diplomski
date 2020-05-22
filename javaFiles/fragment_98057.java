Pattern p = Pattern.compile("(\\w+) \\1");
    String line = "Hello hello this is a test test in order\norder to see if it deletes duplicates Duplicates words.";

    Matcher m = p.matcher(line.toUpperCase());

    StringBuilder sb = new StringBuilder(1000);
    int idx = 0;

    while (m.find()) {
        sb.append(line.substring(idx, m.end(1)));
        idx = m.end();
    }
    sb.append(line.substring(idx));

    System.out.println(sb.toString());
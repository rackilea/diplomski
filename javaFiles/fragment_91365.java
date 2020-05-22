StringBuilder sb = new StringBuilder();
    while (matcher.find()) {
        matcher.appendReplacement(sb, "/^|");
    }
    matcher.appendTail(sb);
    System.out.println(sb.toString());
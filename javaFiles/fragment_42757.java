String SQL = "...";

Pattern regex = Pattern.compile("(?i)nvl\\(([^\\,)]+),([^\\),]+)\\)");
Matcher matcher = regex.matcher(SQL);

String replacement = "CASE WHEN $1 IS NULL THEN $2 WHEN $1 == 0 THEN $2";
String s = matcher.replaceAll(replacement);
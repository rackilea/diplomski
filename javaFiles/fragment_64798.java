String s = "(brown) \"fox\" 'c';foo bar || 55.555;\"foo\";'bar')(;{ gray fox=-56565.4546; foo boo=\"hello\"{";
Pattern p = Pattern.compile("([\"'])(?:[^\"']+|(?!\\1)[\"'])*\\1|\\|\\||<=|&&|[()\\[\\]{};=#]|[\\w.-]+");
Matcher m = p.matcher(s) ;  

 while (m.find()) {
    System.out.println("item = `" + m.group() + "`");
}
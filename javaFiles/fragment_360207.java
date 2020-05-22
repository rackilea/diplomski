String str = "views: 120 upvotes: 540";
Pattern p = Pattern.compile("views:\\s*(\\d+)\\s+upvotes:\\s*(\\d+)",
            Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(str);
if (m.matches()) {
    int views = Integer.parseInt(m.group(1));
    int upvotes = Integer.parseInt(m.group(2));
    System.out.printf("%d %d%n", views, upvotes);
}
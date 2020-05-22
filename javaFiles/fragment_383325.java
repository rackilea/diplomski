String pattern = "<img class=\"galleryElement shown\" (data-)?src=\"([^\"]*?)\"";
Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher("<img class=\"galleryElement shown\" data-src=\"abc\" />");
while (m.find()) {
    System.out.println(m.group(2));
}
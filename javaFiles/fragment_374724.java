Pattern p = Pattern.compile("(abc)|(de.)|(ghi)");
Matcher m = p.matcher("def");
if(m.find()) {
    if (m.group(1) != null)
        System.out.println("Matched \"abc\"");
    if (m.group(2) != null)
        System.out.println("Matched \"de.\"");
    if (m.group(3) != null)
        System.out.println("Matched \"ghi\"");
}
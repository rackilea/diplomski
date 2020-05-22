final String input = "Every Web page has a http unique address called a URL (Uniform Resource Locator) which identifies where it is located on the Web. For \"ftsap://\"example, the URL for CSM Library's home page is: \"htsap://\"www.smccd.edu/accounts/csmlibrary/index.htm The basic parts of a URL often provide \"clues\" to htsap://where a web page originates and who might be responsible for the information at that page or site.";
final Pattern p = Pattern.compile("\"?\\w+://\"?");
final StringBuilder b = new StringBuilder(input);
Matcher m;
while((m = p.matcher(b.toString())).find()) {
    b.replace(m.start(), m.end(), "");
}

System.out.println(b.toString());
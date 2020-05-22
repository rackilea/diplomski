String str = "abc.123,a";
Pattern ptrn = Pattern.compile("(?<!\\p{L})123(?!\\p{L})");
Matcher matcher = ptrn.matcher(str);
if (matcher.find()) {
    System.out.println("YES");
}
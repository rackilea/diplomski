String str = "mya!phaNum3rics-456-456-lll";
Pattern ptrn = Pattern.compile("-([^-]+)-\\1-lll$");
Matcher matcher = ptrn.matcher(str);
if (matcher.find()) {
    System.out.println(matcher.group(0) + " matched!");
}
Matcher matcher = Pattern.compile("charset\\s*=\\s*([^ ;]+)").matcher(contentType);
String charset = "utf-8"; // default
if (matcher.find()) {
    charset = matcher.group(1);
}
System.out.println(con.getContentType());

BufferedReader in = new BufferedReader(new InputStreamReader(
    con.getInputStream(), charset));
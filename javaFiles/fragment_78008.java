Path path = profileFile.toPath();
Charset charset = StandardCharsets.UTF_8;
String replaceString = "";
String content = new String(Files.readAllBytes(path), charset);
Pattern pattern = Pattern.compile("xmi:id=\"([A-Za-z0-9_]*)\"");
Matcher matcher = pattern.matcher(content);
while (matcher.find())
{
  replaceString = matcher.group(0);
  Pattern p = Pattern.compile("\"([^\"]*)\"");
  Matcher m = p.matcher(replaceString);
  if (m.find())
  {
    System.out.println("is this the real life:    " + m.group(1));
    replaceString = m.group(1);
    content = content.replaceAll(replaceString, "");
  }
}

Files.write(path, content.getBytes(charset));
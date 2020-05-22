public Source resolve(String href, String base) {
  if (href.equals("functx-package.xsl")) {
     return new StreamSource(new StringReader(functxAsString));
  } else {
     return null;
  }
}
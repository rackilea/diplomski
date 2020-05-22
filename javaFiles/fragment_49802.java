String[] languages = {
  "catalan_ok.png",
  "suomi_ok.png",
  //...
}

for (String base : languages) {
  String file = String.format("imagerepo/language/%s", base);
  if (s.exists(file) != null) {
    s.click(file);
    break;
  }
}
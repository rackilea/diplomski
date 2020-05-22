Element el = doc.select("div#test").first();
  for (Element elC : el.children()) {
      elC.remove();
  }
  Element nel = el.appendElement("b");
  nel.text("Test");
String ref = null;
for (Element el : doc.select(".squaresContent.narrow")) {
  for (Element elem : el.select(".productItem.first2Col.first3Col.first4Col.first a")) {
    ref = elem.attr("abs:href");
  }
}
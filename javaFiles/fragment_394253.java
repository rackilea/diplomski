String ref = null;
try{
    Element aEl = doc.select(".squaresContent.narrow").last()
          .select(".productItem.first2Col.first3Col.first4Col.first a").last();
    ref = aEl.attr("abs:href");
}
catch (NullPointerException e){
    e.printStackTrace();
}
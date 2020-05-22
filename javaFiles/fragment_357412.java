Document doc = Jsoup.parse(html);
Element content = doc.getElementById("someid");
Elements p= content.getElementsByTag("p");

String pConcatenated="";
for (Element x: p) {
  pConcatenated+= x.text();
}

System.out.println(pConcatenated);//sometext another p tag
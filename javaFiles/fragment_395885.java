String htmlString = "<html><body><table><td> SCH4UE-01 : Chemistry <br> Block: 1 - rm. 315 <br></td></table></body></html>";

Document doc = Jsoup.parse(htmlString);

Elements tdElements = doc.select("td");

for (Element tdElement : tdElements){
    System.out.println(tdElement.childNode(0));
}
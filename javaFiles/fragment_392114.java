String source = "<u>Download Instructions:</u><br/><a class=\"postlink\" href=\"https://1test.com/info\">https://test.com/info</a><br/><a class=\"postlink\" href=\"https://2test.com/info\">https://test.com/info</a><br/><a class=\"postlink\" href=\"https://3test.com/info\">https://test.com/info</a><br/>Mirror:<br/><a class=\"postlink\" href=\"http://global.eu/navi1.html\">http://global.eu/navi.html</a><br/><a class=\"postlink\" href=\"http://global.eu/navi2.html\">http://global.eu/navi.html</a><br/>Additional:<br/><a class=\"postlink\" href=\"http://main.org/navi.html\">http://main.org/navi.html</a>";

Document doc = Jsoup.parse(source, "UTF-8");

List<String> downloadInstructionsUrls = new ArrayList<>();
List<String> mirrorUrls = new ArrayList<>();

for (Element el : doc.select("a.postlink")) {
    Node previousSibling = el.previousSibling();

    while( !(previousSibling.nodeName().equals("u") || previousSibling.nodeName().equals("#text")) ){
        previousSibling = previousSibling.previousSibling();
    }

    String identifier = previousSibling.toString();

    if(identifier.contains("Download Instructions")){
        downloadInstructionsUrls.add(el.attr("abs:href"));
    }else if(identifier.toString().contains("Mirror")){
        mirrorUrls.add(el.attr("abs:href"));
    }
}

System.out.println("Url for download instructions:");
downloadInstructionsUrls.forEach(url -> {System.out.println("\t"+url);});
System.out.println("Url for mirror:");
mirrorUrls.forEach(url -> {System.out.println("\t"+url);});
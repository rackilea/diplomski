NodeList nodes = doc.getElementsByTagName("movies");

Element element = (Element) nodes.item(0);
NodeList movieList = element.getElementsByTagName("movie");
for (int i = 0; i < movieList.getLength(); i++) {
    Element movieElement = (Element) movieList.item(i);
    System.out.println(movieElement.getAttributes().getNamedItem("id").getNodeValue());
    NodeList name = movieElement.getElementsByTagName("title");
    NodeList year = movieElement.getElementsByTagName("year");
    NodeList genres = movieElement.getElementsByTagName("genres");
    Element genreline = (Element) genres.item(0);

    System.out.println(name.item(0).getFirstChild().getTextContent());
    System.out.println(year.item(0).getFirstChild().getTextContent());
    System.out.println(genreline.getElementsByTagName("genre").item(0).getTextContent() 
               + ":" + genreline.getElementsByTagName("genre").item(1).getTextContent());
}
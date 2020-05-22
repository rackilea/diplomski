NodeList nList = doc.getElementsByTagName("vertex");
NodeList edgeList;

// For each vertex, get all "edge" children
for (int i = 0; i < nList.getLength(); i++)  {
    edgeList = ((Element)nList.item(i)).getElementsByTagName("edge");

    // For each edge under this vertex, do something
    for (int j = 0; j < edgeList.getLength(); j++) {

        // test that it works
        System.out.println(edgeList.item(j).getTextContent());
    }
}
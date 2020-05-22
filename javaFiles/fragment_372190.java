Element e = (Element) noteListFileNames.item(i);

NodeList children = e.getChildNodes();

for (int j = 0; j < children.getLength(); j++) {
    if (children.item(j).getNodeName().equals("job_id")) {
        map.put(children.item(j).getNodeName(),
        children.item(j).getTextContent());
        xmlFileNames.add(map);
    }
}
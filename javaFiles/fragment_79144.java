NodeList sphereList = document.getElementsByTagName("sphere");
for (int i = 0; i < sphereList.getLength(); i++) {
    Element sphereElem = (Element) sphereList.item(i);
    Element positionElem = (Element) sphereElem.getElementsByTagName("position").item(0);

    double radius = Double.parseDouble(sphereElem.getAttribute("radius"));
    double x = Double.parseDouble(positionElem.getAttribute("x"));
    double y = Double.parseDouble(positionElem.getAttribute("y"));
    double z = Double.parseDouble(positionElem.getAttribute("z"));

    // use values here
}
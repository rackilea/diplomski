for (int j = 0; j < current.getLength(); j++) {
    if (current.item(j).getNodeType() == Node.ELEMENT_NODE) { // add this!
        tempData.add(current.item(j).getTextContent().trim());
        System.out.println(current.item(j).getTextContent().trim() + " - str to note every output line");
    }
}
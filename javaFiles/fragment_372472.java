NodeList nodeList = doc.getElementsByTagName("solution");
Double requiredCost = 505.9208295302417;
for (int i = 0; i < nodeList.getLength(); i++) {

    Node solutionNode = nodeList.item(i);

    if (solutionNode.getNodeType() == Node.ELEMENT_NODE) {
        Element solutionElement = (Element) solutionNode;
        Node costNode = solutionElement.getElementsByTagName("cost").item(0);

        // if correct cost, proceed to parse further
        Double costValue = Double.valueOf(costNode.getTextContent());
        if (Double.compare(requiredCost, costValue) == 0) {

            // there you go, found the node with the cost 505.9208295302417
            // now just parse all the node elements you need here
        }
    }
}
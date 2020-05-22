for(int i = 0; i < transactions.getLength(); i++) {
    Node transactionNode = transactions.item(i);
    if ( transactionNode instanceof Element ) {
        transactionElem = (Element)transactionNode;
        NodeList elemList = transactionElem.getElementsByTagName("id");
        if ( elemList.getLength() >= 1 ) {
            Node idNode = elemList.item(0);
            // Do whatever you want with the id node
        }
        elemList = transactionElem.getElementsByTagName("date");
        if ( elemList.getLength() >= 1 ) {
            Node dateNode = elemList.item(0);
            // Do whatever you want with the date node
        }
        elemList = transactionElem.getElementsByTagName("time");
        if ( elemList.getLength() >= 1 ) {
            Node timeNode = elemList.item(0);
            // Do whatever you want with the time node
        }
    }
}
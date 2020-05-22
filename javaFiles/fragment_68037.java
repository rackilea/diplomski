for(int i = 0; i < transactions.getLength(); i++) {
    Node transaction = transactions.item(i);
    NodeList transactionChildren = transaction.getChildNodes();
    for ( int j = 0; j < transactionChildren.getLength(); j++ ) {
        Node elem = transactionChildren.item(j);
        switch ( elem.getNodeName() ) {
            case "id":
                // Whatever processing you want for id
                break;
            case "time":
                // Whatever processing you want for time
                break;
            case "date":
                // Whatever processing you want for date
                break;
        }
    }
}
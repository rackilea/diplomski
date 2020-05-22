for (int i = 0; i < clients.getLength(); i++) {
    Element client = (Element) clients.item(i);
    String name = client.getAttribute("name");
    NodeList transactions = client.getElementsByTagName("transaction");
     int sum =0;
    for(int j=0; j<transactions.getLength(); j++) {
            Element transaction = (Element) transactions.item(j);
            sum = sum + Integer.parseInt(transaction.getAttribute("amount"));

    }

    System.out.println("Client name : " +name);
    System.out.println("Sum : " + sum );
}
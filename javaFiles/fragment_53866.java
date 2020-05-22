interface Query {
    boolean executeQuery();
}

// client code...
Client client = new Client(...);
client.setQuery(new Query3(String num, String pageNum));
client.query(); // calls query.executeQuery();
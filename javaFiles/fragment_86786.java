Hashtable<String, List<Message>> originalTable = new Hashtable<String, List<Message>>();
// ... put some data into originalTable

// put originalTable into bundle    
Bundle bundle = new Bundle();
bundle.putSerializable("table", originalTable);

// extract table from bundle
Hashtable<String, List<Message>> extractedTable = (Hashtable<String, List<Message>>)bundle.getSerializable("table");

// Now, extractedTable should contain same data as originalTable
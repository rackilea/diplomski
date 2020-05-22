Map<String, Set<String>> distinctProductsPerClient = new HashMap<String, Set<String>>();
// Process each CSV file line which is now contained within
// the linesList list Array
// Start from 1 to skip the first line
for (int i = 1; i < linesList.size(); i++) {
    String line = linesList.get(i);
    String[] data = line.split(csvSplitBy);
    String productId = data[1];
    String clientId = data[2];
    String date = data[3];

    // Determine if Column 4 has the desired date
    // and count the values
    if (date.contains("10/12/2017"))  {
        if (!distinctProductsPerClient.containsKey(clientId)) {
            distinctProductsPerClient.put(clientId, new HashSet<>());
        }
        distinctProductsPerClient.get(clientId).add(productId);

    }
}

for (final String clientId : distinctProductsPerClient.keySet()) {
    System.out.println(clientId + ": " + distinctProductsPerClient.get(clientId).size());
}
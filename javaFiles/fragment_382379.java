protected void readData(File file, Map<String, Integer> data) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line = null;
        // Read each line
        while ((line = br.readLine()) != null) {
            //...
            // Store the key/value pairs together some how
            String name = parts[0];
            if (data.containsKey(name)) {
                int previous = data.get(name);
                sum += previous;
            }
            data.put(name, sum);
        }
    }
}
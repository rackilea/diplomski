Map<String, String> map = new HashMap<>();
String line = "";

try (BufferedReader br = new BufferedReader(new FileReader("file2.txt"))) {
    while ((line = br.readLine()) != null) {
        String[] parts = line.split("-");
        map.put(parts[0], parts[1]);
    }
}
catch (IOException e) {
    // handle exception
}

try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
    while ((line = br.readLine()) != null) {
        for (Map.Entry< String, String > entry : map.entrySet()) {
            String pattern = "\\b" + entry.getKey() + "\\b";
            line = line.replaceAll(pattern, entry.getValue());

            // now record the updated line; printed to the console here for demo purposes
            System.out.println(line);
        }
    }
}
catch (IOException e) {
    // handle exception
}
List<String> listTest = new ArrayList<String>();
try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-16"))) {
    String line;
    while ((line = br.readLine()) != null) {
        listTest.add(line);
    }
    System.out.println(listTest);
} catch (IOException e) {
    System.out.println("There is IOException!");
}
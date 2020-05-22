public Map<String, String> Payload1() throws IOException {
    Scanner sc = new Scanner (new File("src/boot/Payload1.txt"));
    Map<String, String> fileMap = new LinkedHashMap<String, String>();
    int counter = 1;
    String key = "";
    while (sc.hasNextLine()) {
        if(counter % 2 != 0) {
            key = sc.nextLine();
        }else {
            fileMap.put(key, sc.nextLine());
        }
        counter++;
    }
    sc.close();
    return fileMap;
}
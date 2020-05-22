public static void main(String args[]) throws IOException {
    Set<String> positive = loadDictionary("positivewordsdictionary");
    Set<String> negative = loadDictionary("negativewordsdictionary");

    File file = new File("fileforparsing");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

    Scanner sc = new Scanner(br);
    String word;
    long positiveCount = 0;
    long negativeCount = 0;
    while (sc.hasNext()) {
        word = sc.next();
        if (positive.contains(word)) {
            System.out.println("Found positive "+positiveCount+":"+word);
            positiveCount++;
        }
        if (negative.contains(word)) {
            System.out.println("Found negative "+positiveCount+":"+word);
            negativeCount++;
        }
    }
    br.close();
}


public static Set<String> loadDictionary(String fileName) throws IOException {
    Set<String> words = new HashSet<String>();
    File file = new File(fileName);
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    Scanner sc = new Scanner(br);
    while (sc.hasNext()) {
        words.add(sc.next());
    }
    br.close();
    return words;
}
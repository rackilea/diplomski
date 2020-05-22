String next[] = {};
HashMap<String, String> dataMap = new HashMap<String, String>();

try {
    CSVReader reader = new CSVReader(new InputStreamReader(getAssets().open("inputFile.csv")));
    for(;;) {
        next = reader.readNext();
        if(next != null) {
            dataMap.put(next[0], next[1]);
        } else {
            break;
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}
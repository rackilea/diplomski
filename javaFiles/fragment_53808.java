Properties translation = new Properties();


    //creates file and stores values of keyMap into the file
    try {
        TreeMap<String, String> translatedMap = new TreeMap<String, String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        });

        InputStreamReader in = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        translation.load(in);

        // Store all values to TreeMap and sort
        for (String key : translation.stringPropertyNames()) {
            keyMap.put(key, translation.getProperty(key));
        }

        in.close();


        Iterator<String> it = keyMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            translatedMap.put(key, keyMap.get(key));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, false), "UTF-8"));

        bw.write("#" + new Date().toString());
        bw.newLine();

        Iterator<String> it2 = translatedMap.keySet().iterator();
        while (it2.hasNext()) {
            String key = it2.next();
            bw.write(key + '=' + translatedMap.get(key));
            bw.newLine();
        }


        bw.close();
    } catch (IOException e) {
            e.printStackTrace();
    }
}
static void loadMap() throws IOException {
    ZipFile file = new ZipFile("testzip.zip");
    Enumeration<? extends ZipEntry> entries = file.entries();
    while (entries.hasMoreElements()) {
        ZipEntry entry = entries.nextElement();
        if (!entry.isDirectory()) {
            streamMap.put(entry.getName(), new BufferedReader(new InputStreamReader(file.getInputStream(entry))));
        }

    }

}

public static void main(String[] args) throws IOException {
    loadMap();

    Iterator<BufferedReader> iter = streamMap.values().iterator();
    while (iter.hasNext()) {            
        BufferedReader reader = iter.next();
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}


OUTPUT:
file 2: First line!
file 2: Second Line!
file 1: First line!
file 1 : Second Line!
BUILD SUCCESSFUL (total time: 0 seconds)
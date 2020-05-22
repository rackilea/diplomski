public void Read(String file) throws IOException {
        BufferedReader in = null;
        InputStream fis;

        try {
            fis = new FileInputStream(file);
            in = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = in.readLine()) != null) {
                String[] file_Array = line.split(" ", 2);
                Add(Integer.parseInt(file_Array[0]),file_Array[1]);
            }
            Display(-1); // -1 for displaying all
        } catch (IOException ex) {
            System.out.println("Input file " + file + " not found");
            System.exit(1);
        } finally {
            in.close();
        }
    }

    public void Add(int item, String fruit) {
        if (tMap.containsKey(item)) {
            fList = tMap.get(item);
        } else {
            fList = new ArrayList<String>();
        }
        fList.add(fruit);
        tMap.put(item, fList);
    }

    public void Display(int key) {
    if(key == -1){
        for (Map.Entry<Integer, List<String>> entry : tMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }else{
        System.out.println(key);
        System.out.println(tMap.get(key));
    }

}
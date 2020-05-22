public static void main (String[] args) throws FileNotFoundException {
        MultiMap multiMap = new MultiHashMap();
        Scanner scanner1 = new Scanner(new File("/obp/f1.csv"));
        Scanner scanner2 = new Scanner(new File("/obp/f2.csv"));
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String[] array = line.split("\\s",2);
            String TheName = array[0];
            String score = array[1];
            multiMap.put(TheName,score);
        }
        while (scanner2.hasNextLine()) {
            String line2 = scanner2.nextLine();
            String[] array2 = line2.split("\\s",2);
            String TheName2 = array2[0];
            String rs = array2[1];
            multiMap.put(TheName2,rs);
        }
        Set<String> keys = multiMap.keySet();
        for (String key : keys){
            System.out.println(key + "\t" + multiMap.get(key) );
        }
    }
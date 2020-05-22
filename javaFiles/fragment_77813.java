public static void main(String args[]) {

    Map<String, Integer> map = new HashMap<String, Integer>();
    // populate map

    int mapSize = 500000;
    int strLength = 5;
    for(int i=0;i<mapSize;i++)
        map.put(RandomStringUtils.random(strLength), RandomUtils.nextInt());

    long start = System.currentTimeMillis();
    // alt. #1
    for (String key : map.keySet()) {
        Integer value = map.get(key);
        // use key and value
    }
    System.out.println("Alt #1 took "+(System.currentTimeMillis()-start)+" ms");

    start = System.currentTimeMillis();
    // alt. #2
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        String key = entry.getKey();
        Integer value = entry.getValue();
        // use key and value
    }
    System.out.println("Alt #2 took "+(System.currentTimeMillis()-start)+" ms");
}
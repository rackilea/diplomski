private static Map<Long,String> fillMap(int items)
{
    Map<Long,String> map = new HashMap<Long,String>(items);
    Random rnd = new Random();

    long start = System.currentTimeMillis();

    for (int ii = 0 ; ii < items ; ii++)
    {
        map.put(new Long(rnd.nextLong()), new String("123456789012345678901234567890"));
    }

    long finish = System.currentTimeMillis();
    double elapsed = ((finish - start) / 1000.0);
    System.out.format("time to produce %d items: %8.3f seconds (map size = %d)\n", items, elapsed, map.size());
    return map;
}
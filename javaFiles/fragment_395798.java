public static <T,U> void dumpList (List<HashMap<T,U>> list) {
    System.out.println("List:");
    for (HashMap<T,U> map:list)
        for (Map.Entry<T,U> e:map.entrySet())
            System.out.println(e.getKey().getClass() + ", " + e.getValue().getClass());
}
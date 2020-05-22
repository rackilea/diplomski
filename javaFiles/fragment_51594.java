public static void main(String[] args) {
    int[][] array = { { 1, 20 }, { 1, 14 }, { 2, 15 }, { 2, 67 },
            { 3, 55 }, { 3, 24 }, { 4, 95 }, { 4, 23 } };

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    System.out.println(array.length);
    for(int i=0;i<array.length; i++)
    {
        if(map.get(array[i][0]) == null)
                map.put(array[i][0], array[i][1]);
        else
            if(map.get(array[i][0]) < array[i][1])
            {
                map.put(array[i][0], array[i][1]);
            }
    }
    System.out.println(map);
}
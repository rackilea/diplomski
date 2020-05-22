public static void main(String t[]) throws IOException {
    int[][] input1 = new int[][] { 
        new int[] { 1, 2, 3, 4, 8 },
        new int[] { 6, 3, 2, 3, 5 },
        new int[] { 3, 9, 7, 1, 3 } };

    int[][] input2 = new int[][] { 
        new int[] { 1, 5, 3, 5, 8 }, 
        new int[] { 5, 3, 5, 3, 5 },
        new int[] { 3, 9, 7, 1, 3 } };

    System.out.println("case 1");
    doWith(input1);
    System.out.println("case 2");
    doWith(input2);
}

public static void doWith(int[][] table){
    Map<Integer, List<Integer>> allIndexes = getAllIndexes(table);
    /* Java 8 style
    Map<Integer, List<Integer>> fiveOccurrencesIndexes = allIndexes.entrySet().stream()
            .filter(e ->e.getValue().size() == ROW_SIZE)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
             */
    Map<Integer, List<Integer>> fiveOccurrencesIndexes = new HashMap<Integer,List<Integer>>();
    for(Map.Entry<Integer,List<Integer>> entry : allIndexes.entrySet()){
        if(entry.getValue().size() == ROW_SIZE){
            fiveOccurrencesIndexes.put(entry.getKey(), entry.getValue());
        }
    }

    fiveOccurrencesIndexes.entrySet().forEach(e -> System.out.println(e.getKey()+ " : "+e.getValue()));
}

// Map of indexes per value
public static Map<Integer,List<Integer>> getAllIndexes(int[][] table){
    Map<Integer,List<Integer>> result = new HashMap<>();
    // we should force minValue < maxValue
    for(int i=0; i<ROW_SIZE; i++){  
        for(int j=0;j<COL_SIZE; j++){
            Integer value = table[j][i];
            if(!result.containsKey(value)){ 
                List<Integer> indexes = new ArrayList<>(); // init value
                result.put(value, indexes);
            }
            result.get(value).add(j);
        }
    }
    return result;
}
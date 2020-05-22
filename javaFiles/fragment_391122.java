public static int rarest (Map<String, Integer> map) {
    List<Integer> list = new ArrayList<Integer>();
    for(Integer i: map.values()) {
        list.add(i);
    }
    int min = Integer.MAX_VALUE, rarestValue = 0;
    for(Integer i: list) {
        int count = Collections.frequency(list, i);
        if(count < min || (count == min && i < rarestValue)) {
            min = count;
            rarestValue = i;
        }
    }
    return rarestValue;  
}
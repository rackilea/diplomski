public static int[] sum(int[] arr,int target) {
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer>(arr.length);
    for(i = 0;i < arr.length;i++) {
        map.add(arr[i],i);
    }
    for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
        int n = entry.getValue();
        int index = entry.getKey();
        if(map.containsKey(target - n)) {
            return new int[] {index,map.get(target - n)};
        }
    }
    return null;
}
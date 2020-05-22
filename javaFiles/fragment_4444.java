public static int solution(int[] arr, int S) { 
    int[] sums = new int[arr.length+1];
    int sum = 0;
    //generate the sums array:
    sums[0] = 0;
    for (int i = 0; i < arr.length; i++) sums[i+1] = sum = sum+arr[i];
    //generate map:
    Map<Integer,List<Integer>> map = new HashMap<>();
    for (int i = 0; i < sums.length; i++) {
       List<Integer> l = map.get(sums[i]);
       if (l == null) { 
           l = new ArrayList<>();
           map.put(sums[i],l);
       }
       l.add(i);
    }
    //find longest:
    int currentMaxLength = Integer.MIN_VALUE;
    for (int i = 0; i < sums.length; i++) { 
       int k = S - sums[i];
       List<Integer> l = map.get(k);
       if (l == null) continue;
       int width = Math.abs(l.get(l.size()-1) -  i);
       if (width > currentMaxLength) currentMaxLength = width;
    }
    return currentMaxLength;
}
public static void main(String[] args) {
    System.out.println(solution(new int[] { 1, 0, -1, 1, 1, -1, -1 }, 2));
}
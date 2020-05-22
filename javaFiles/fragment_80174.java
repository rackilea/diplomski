private static Random rnd = new Random();
...
public static Set<Integer> randomSample(int n, int m){
    HashSet<Integer> res = new HashSet<Integer>(m);
    for(int i = n - m; i < n; i++){
        int item = rnd.nextInt(i + 1);
        if (res.contains(item))
            res.add(i);
        else
            res.add(item); 
    }
    return res;
}
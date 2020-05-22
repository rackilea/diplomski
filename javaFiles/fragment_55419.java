public static void main (String[] args) throws java.lang.Exception
{
    HashMap<String, HashMap<String, Integer>> hash = new HashMap<String, HashMap<String, Integer>>();
    for(int i=0; i<5;i++){
        HashMap<String, Integer> insideHash = new HashMap<String, Integer>();
        insideHash.put("A"+i, i);
        hash.put("AA"+i, insideHash);
    }
    System.out.println(hash);
}
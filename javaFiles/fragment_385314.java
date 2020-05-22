private static List<List<Integer>> listDoubleSequences(String in)
{
    List<List<Integer>> result = new ArrayList<>();

    //map all characters to their indices in the inputstring
    HashMap<Character , List<Integer>> posMap = new HashMap<>();

    for(int i = 0 ; i < in.length() ; i++)
    {
        char c = in.charAt(i);

        if(posMap.get(c) == null)
            posMap.put(c , new ArrayList<>());

        posMap.get(c).add(i);
    }

    System.out.println(posMap);

    posMap.values().forEach(indices -> {
        //find all possible permutations with length 2
        for (int i = 0; i < indices.size(); i++)
            for (int j = i + 1; j < indices.size(); j++) {
                List<Integer> seq = new ArrayList<>();
                seq.add(indices.get(i));
                seq.add(indices.get(j));

                result.add(seq);
            }
    });

    System.out.println("Found double sequences:");
    result.forEach(l -> printSeq(in, l));

    return result;
}
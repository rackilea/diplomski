public static void sqrSubseqCount(String in)
{
    List<List<Integer>> len_2_seq = listDoubleSequences(in);
    List<List<Integer>> prev_round = new ArrayList<>(len_2_seq);
    final Set<List<Integer>> next_round = new HashSet<>();

    int count = len_2_seq.size();

    System.out.println();
    System.out.println("Searching longer sequences:");

    while(!prev_round.isEmpty())
    {
        next_round.clear();

        prev_round.forEach(l -> len_2_seq.forEach(l2 -> {
            List<Integer> merge = merge(l , l2);

            if(merge != null && !next_round.contains(merge))
            {
                next_round.add(merge);
                printSeq(in , merge);
            }
        }));

        count += next_round.size();

        prev_round.clear();
        prev_round.addAll(next_round);
    }

    System.out.println();

    System.out.println("Total sequences found: " + count + " in: " + in);
}
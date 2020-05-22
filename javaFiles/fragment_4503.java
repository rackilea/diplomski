public static void main(String[] args) {
    int longest = 0;
    int numTerms = 0;
    int i;
    long j;

    Map<Long, Integer> map = new HashMap<>();

    for (i = 1; i <= 10000000; i++) {
        j = i;

        Integer terms = map.get(i);
        if (terms != null) {
            continue;
        }
        int currentTerms = 1;

        while (j != 1) {
            currentTerms++;

            if (currentTerms > numTerms){
                numTerms = currentTerms;
                longest = i;
            }

            if (j % 2 == 0){
                j = j / 2;

                // Maybe check the map only here
                Integer m = map.get(j);
                if (m != null) {
                    currentTerms += m;
                    break;
                }
            }
            else{
                j = 3 * j + 1;
            }
        }
        map.put(j, currentTerms);
    }
    System.out.println("Longest: " + longest + " (" + numTerms + ").");
}
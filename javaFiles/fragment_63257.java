static Random r = new Random();
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int seed = r.nextInt();
            String t = generate(3,7,seed);
            String s = generate(7,11,seed);

            int index = 0;
            for (int i = 1; i < s.length()/2; i++) {
               if (s.regionMatches(0,s,i,i)) {
                  index = i;
               }
            }
            int index = 0;
            for (int idx = 1; idx < s.length()/2; idx++) {
              if (s.regionMatches(0,s,idx,idx)) {
                index = idx;
              }
            }
            String small = s.substring(0,index);

            // Check to make certain this isn't just a repeated character.
            small = small.replaceAll("^(.)\\1+$", "$1"); 
            boolean isDivisible = s.length() % t.length() == 0;
            System.out.printf("%s is " + ((isDivisible) ? "" : "NOT") 
                 + " divisible by %s%n",
                        s, t);

            System.out.println(
                    "The smallest string is " + small + "\n");
        }

    }

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String generate(int s, int e, int seed) {
        r.setSeed(seed);
        String stem = IntStream.range(3, 8).mapToObj(i -> {
            int len = r.nextInt(26);
            return alphabet.substring(len, len + 1);
        }).collect(Collectors.joining());
        return stem.repeat(r.nextInt(e)+s);
    }
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter your String");
    String line = in.readLine();
    HashMap<Character,Integer> counts = new HashMap<>();
    for(char c : line.toCharArray()) {
        Integer count = counts.get(c);
        if (count == null) {
            count = 0;
        }
        counts.put(c, ++count);
    }
    List<Entry<Character,Integer>> list = new ArrayList<>(counts.entrySet());
    Collections.sort(list, new Comparator<Entry<Character,Integer>>() {
        @Override
        public int compare(Entry<Character, Integer> o1,
                Entry<Character, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    });
    for(Entry<Character,Integer> entry : list) {
        System.out.println("The character "+entry.getKey() +" has occured for "+ entry.getValue()+" times");
    }
String word = "dog";
    Set<Character> set1 = new HashSet();
    for (char c : word.toCharArray()) {
        set1.add(c);
    }
    String  dictionaryWord;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while((dictionaryWord = br.readLine()) != null)  {
        Set<Character> set2 = new HashSet();
        for (char c : dictionaryWord.toCharArray()) {
            set2.add(c);
        }           Set<String> intersection = new HashSet(CollectionUtils.intersection(set1, set2));
        if (set1.equals(intersection)) {
            System.out.println(dictionaryWord);
        } else System.out.println("bad");
    }
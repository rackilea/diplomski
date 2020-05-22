String word = "dog";
    String  dictionaryWord;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while((dictionaryWord = br.readLine()) != null)  {
        Set<Character> chars = new HashSet<Character>();
        for (char c : word.toCharArray()) {
            chars.add(c);
        }
        boolean match = true;
        for (Character c : chars) {
            String s = "" + c;
            if (!dictionaryWord.contains(s)) {
                match = false;
                break;
            }
        }
        if (match == true) 
            System.out.println(dictionaryWord);
    }
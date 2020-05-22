String s = "The big brown fox";
    Map<Character, Float> m = new TreeMap<Character, Float>();
    for (char c : s.toCharArray()) {
        if (m.containsKey(c))
            m.put(c, m.get(c) + 1);
        else
            m.put(c, 1f);
    }

    for (char c : s.toCharArray()) {
        float freq = m.get(c) / s.length();
        System.out.println(c + " " + freq);
    }
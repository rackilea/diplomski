LinkedList<Character> list = new LinkedList<>(Arrays.asList('w', 'e', 'r', 's', 'o', 'm', 'a', 't'));
    int n = list.size();
    for(int i = 0; i < n; i++) {
        char c = list.get(i);
        if ("aeiuoAEIUO".indexOf(c) != -1) {
            list.remove(i);
            list.add(c);
            n--;
        }
    }
    System.out.println(list);
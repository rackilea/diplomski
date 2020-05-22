Set<Character> set = new TreeSet<Character>();
for (char c = 'a'; c < 'i'; c++) {
    set.add(c);
}

List<Character> list = new ArrayList<Character>(set);
Collections.shuffle(list);
System.out.println(list.subList(0, 3));
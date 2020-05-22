Random random = new Random();
int index = 0;

List<Character> list = new ArrayList<Character>(set);
Set<Character> newSet = new HashSet<Character>();
while (newSet.size() < 3) {
    index = random.nextInt(set.size());
    newSet.add(list.get(index));
}
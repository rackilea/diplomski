HashSet<Integer> hs = new HashSet(arr);
HashSet<Integer> running = new HashSet();
int sum = 6;
Iterator<Integer> iter = hs.iterator();
while (iter.hasNext()) {
    int num = iter.next();
    if (running.contains(sum - num)) {
        iter.remove();
    } else {
        running.add(num);
    }
}
PriorityQueue<TempClass> queue = new PriorityQueue<>(Comparator.comparingInt(TempClass::getCount));
for (TempClass temp : tempList) {
    queue.offer(temp);
    if (queue.size() > 3) {
        queue.poll();
    }
}

LinkedList<TempClass> result = new LinkedList<>();
while (queue.size() > 0) {
    result.push(queue.poll()); //obj5, obj1, obj3
}
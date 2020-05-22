Deque<Double> deque;
Double[] array = Double[deque.size()];
int count = 0;
for (Iterator<Double> i = deque.iterator(); i.hasNext();) {
    array[count++] = i.next();
}
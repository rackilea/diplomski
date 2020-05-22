// Note that saved has a size defined at construction, 
// which makes this efficient. 
final List<Deque<Point>> saved = new ArrayList<Deque<Point>>(12);
for (int i = 0; i < 12; i++) {
   saved.add(new LinkedList<Point>());
}
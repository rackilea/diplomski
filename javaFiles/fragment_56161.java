private ArrayMap<Rectangle, Integer> livinglamas;

//...

livinglamas.put(livinglama, someInt);


//...
Iterator<Entry<Rectangle, Integer>> iter = livinglamas.iterator();
while (iter.hasNext()){
    Entry<Rectangle, Integer> entry = iter.next();
    Rectangle lama = entry.key;
    int value = entry.value;
    //...
}
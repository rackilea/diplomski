List<Float> yourList = ...;
// fill yourList
List<Float> results = new ArrayList<>();
Iterator<Float> it = yourList.iterator();
final int MAX = 12;
while (it.hasNext()) {
    float sum = 0f;
    int counter = 1;
    //iterating 12 times
    //still, check if there's an element in your list
    while (counter <= MAX && it.hasNext()) {
        sum += it.next();
        counter++;
    }
    result.add(sum);
}
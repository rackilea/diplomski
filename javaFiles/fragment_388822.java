private float  filterValue(LinkedList<Float> listOfItems)
{
    final float ALPHA = 0.2f;
    float filtered;

    int marker = listOfItems.size();

    if (listOfItems.size() > 0){

        marker = listOfItems.size() - 1;

        float current = listOfItems.pollLast();
        float previous = listOfItems.get(marker); <<-- line 282

        filtered = (float) previous + ALPHA*(current - previous);
    }
    return filtered;
}
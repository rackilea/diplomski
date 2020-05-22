public class ListComparator implements Comparator<List<Integer>>
{
    private final int indexToCompare;

    public ListComparator(int indexToCompare)
    {
        this.indexToCompare = indexToCompare;
    }

    public int compare(List<Integer> first, List<Integer> second)
    {
        // TODO: null checking
        Integer firstValue = first.get(indexToCompare);
        Integer secondValue = second.get(indexToCompare);
        return firstValue.compareTo(secondValue);
    }
}
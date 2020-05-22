public class DistanceComparator extends Comparator<MyDistance> {
    @Override
    public int compare(MyDistance dist1, MyDistance dist2) {
        return dist1.getMilage().compareTo(dist2.getMilage());
    }
}
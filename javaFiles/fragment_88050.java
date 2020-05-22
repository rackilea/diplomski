public class IntersectComparator implements Comparator<AssetCategory> {
    public int compare(AssetCategory l, AssetCategory r) {
        if (l.getEnd().isBefore(r.getStart())) {
            return -1;
        }
        if (r.getEnd().isBefore(l.getStart())) {
            return 1;
        }
        return 0;
    }
}
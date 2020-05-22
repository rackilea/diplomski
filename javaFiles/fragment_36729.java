public class BloatTimeComparator implements Comparator<Bloat> {
    public int compare(Bloat bloat1, Bloat bloat2) {
        if (bloat1.timeInMilliseconds > bloat2.timeInMilliseconds) {
            return 1;
        } else if (bloat1.timeInMilliseconds < bloat2.timeInMilliseconds) {
            return -1;
        } else {
            return 0;
        }
    }
}
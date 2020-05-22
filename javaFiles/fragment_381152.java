public class MyArrayListComparator implements java.util.Comparator<ArrayList> {

    public int compare(ArrayList al1, ArrayList al2) {
        if (al1.size() > al2.size())
            return 1;
        if (al1.size() < al2.size())
            return -1;
        return 0;
    }
}
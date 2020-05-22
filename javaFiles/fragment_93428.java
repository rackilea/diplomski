public class MyObjectComparator implements Comparator<MyObject> {

List<Integer> list;

MyObjectComparator(List<Integer> list)
{
    this.list = list;
}

@Override
public int compare(MyObject o1, MyObject o2) {
    return Integer.compare(list.indexOf(o1.getId()), list.indexOf(o2.getId()));
}